package CaisseDeconnectee.Backend.Test;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



@SpringBootTest
public class SpringTestNGTest extends AbstractTestNGSpringContextTests {

    
    private WebDriver webDriver;

    @Value("${app.url}")
    private String appUrl;

 
    @BeforeTest
    protected void setupWebDriver(){
        System.setProperty("webdriver.chrome.driver","C:/Users/User/Downloads/chromedriver/chromedriver.exe");
        webDriver =new ChromeDriver();
        webDriver.get(appUrl);
        webDriver.manage().window().maximize();

    }
    @Test
    @Order(1)
    public void testLogin() throws InterruptedException {
        Thread.sleep(3000);

  
         WebElement txtUserName= webDriver.findElement(By.id("userName"));
         WebElement txtPassword=webDriver.findElement(By.id("userPassword"));
         //webDriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
         txtUserName.sendKeys("popo");
         Thread.sleep(3000);

        // webDriver.manage().wait(2000);
         txtPassword.sendKeys("poo");
         Thread.sleep(3000);

         //webDriver.manage().wait(2000);
       //  webDriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
         WebElement b =webDriver.findElement(By.id("bouton1"));
         b.click();
       //mainPage.PerformLogin();
    }
    
    @Test
    @Order(2)
    public void testfact() throws InterruptedException {
        Thread.sleep(3000);

        webDriver.get("http://localhost:4200/chef/dashboard");
         //webDriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        // webDriver.manage().wait(2000);
         //webDriver.manage().wait(2000);
       //  webDriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
         WebElement b =webDriver.findElement(By.id("fact"));
         b.click();
         Thread.sleep(3000);

         webDriver.get("http://localhost:4200/chef/facture");
         WebElement rech= webDriver.findElement(By.id("rech"));
         rech.sendKeys("string");
         Thread.sleep(3000);

         WebElement serch= webDriver.findElement(By.id("serch"));
         serch.click();
       //mainPage.PerformLogin();
    }
    @AfterTest
    public void quit() throws InterruptedException {
        Thread.sleep(10000);

        webDriver.quit();
    }

    @BeforeClass(alwaysRun = true)
    @BeforeSuite(alwaysRun = true)
    @Override
    protected void springTestContextPrepareTestInstance() throws Exception {
        super.springTestContextPrepareTestInstance();
    }

}
