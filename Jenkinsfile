node {
  stage('SCM') {
    checkout scm
  }

  withMaven(maven: 'MAVEN_3.8.2', jdk: 'JDK11', mavenLocalRepo: params.repository) {
      stage("Clean Up") {
          echo "********** CLEAN ************"
          sh "mvn clean"
      }

      stage("Maven Compile") {
           echo "********** MAVEN COMPILE ************"
           sh "mvn compile"
      }

      stage("Maven Test") {
           echo "********** MAVEN TEST ************"
           sh "mvn test"
      }

      stage("Maven Package") {
            echo "********** MAVEN PACKAGE ************"
            sh "mvn package"
      }

      stage('SonarQube Analysis') {

        withSonarQubeEnv() {
          sh """mvn -X sonar:sonar \
                             -Dsonar.projectKey=Jenkins \
                             -Dsonar.login=dfdb726e9c6ee8d5ac6ac4d561bf5771c4499e2d
          """
        }
      }
  }

}