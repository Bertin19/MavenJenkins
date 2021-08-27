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
      sh """${mvn}/bin/ mvn -X sonar:sonar \
                         -Dsonar.projectKey=mavenJenkins \
                         -Dsonar.host.url=http://localhost:9000 \
                         -Dsonar.login=dfdb726e9c6ee8d5ac6ac4d561bf5771c4499e2d
      """
    }
  }
}