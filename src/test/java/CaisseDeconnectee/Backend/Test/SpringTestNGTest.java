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
         txtUserName.sendKeys("popo");
         Thread.sleep(3000);

         txtPassword.sendKeys("poo");
         Thread.sleep(3000);

         
         WebElement b =webDriver.findElement(By.id("bouton1"));
         b.click();
    }
    
    @Test
    @Order(2)
    public void testfact() throws InterruptedException {
        Thread.sleep(3000);

        webDriver.get("http://localhost:4200/chef/dashboard");
         WebElement b =webDriver.findElement(By.id("fact"));
         b.click();
         Thread.sleep(3000);

         webDriver.get("http://localhost:4200/chef/facture");
         WebElement rech= webDriver.findElement(By.id("rech"));
         rech.sendKeys("string");
         Thread.sleep(3000);

         WebElement serch= webDriver.findElement(By.id("serch"));
         serch.click();
    }
    
    @Test
    @Order(3)
    public void testpayer() throws InterruptedException {
        Thread.sleep(3000);

         WebElement b =webDriver.findElement(By.id("p"));
         b.click();
         Thread.sleep(3000);
         WebElement ver= webDriver.findElement(By.id("v"));
         ver.clear();
         Thread.sleep(1000);
         ver.sendKeys("100");
         Thread.sleep(3000);
         WebElement e =webDriver.findElement(By.id("encais"));
         e.click();
         

    }
    @AfterTest
    public void quit() throws InterruptedException {
        Thread.sleep(15000);

        webDriver.quit();
    }

    @BeforeClass(alwaysRun = true)
    @BeforeSuite(alwaysRun = true)
    @Override
    protected void springTestContextPrepareTestInstance() throws Exception {
        super.springTestContextPrepareTestInstance();
    }

}