def gv

pipeline {
  
  agent any
  tools {
    maven 'M2_HOME' 
  }
  stages {
    stage("init") {
      steps {
         script {
           gv = load "script.groovy"
         }
       }
     }
    stage("MVN CLEAN") {      
      steps {
        script {
          gv.mvnclean()    
      }
    }
  }
    stage("MVN COMPILE") {
      steps {
        script {
          gv.mvncompile()
      }
    }
  }
    stage("MVN SONARQUBE") {
      steps {
        script {
            withSonarQubeEnv('SonarQube'){
                bat "mvn  clean verify sonar:sonar -Dsonar.projectKey=test -Dsonar.host.url=http://localhost:9000 -Dsonar.login=sqp_889a1bfdd45c3749f64b32b68907f1907234fae1"
            }
          
      }
    }
  }
   stage('JUNIT-MOCKITO') {
     steps {
      script {
        gv.JunitMockito()
   }
  }
 }
  
  }
}