node {
  stage('SCM') {
    checkout scm
  }

  stage("Clean Up") {

  }

  stage("Test"){
    
  }

  stage('SonarQube Analysis') {
    def mvn = tool 'MAVEN_3.8.2';
    withSonarQubeEnv() {
      sh "${mvn}/bin/mvn sonar:sonar"
    }
  }
}