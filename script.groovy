def mvnclean() {
  echo "cleaning the application..."
  bat'mvn clean'
}
def mvncompile() {
  echo "compiling the application..."
  bat'mvn compile'
}
def mvnsonarqube() {
  echo "Analyzing the application..."
  bat'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=admin123'
}

def JunitMockito() {
  echo "Testing the application..."
  bat'mvn -Dtest=JwtServiceTest,HrPayCashDeskSessionServiceTest,HrPayCashDeskSessionControllerTestIntegration,DisAdmUserProfileControllerTestIntegration,HrPayCashDebtServiceTestMock,HrPartyControllerTestIntegration,SpringTestNGTest test '
  
}
def deploynexus() {
echo "Deploy to nexus..."
 bat'mvn deploy -DskipTests'
}


  return this