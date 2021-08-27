#!groovy


node {

    def scannerHome = tool 'SonarQubeScanner'

  stage('SCM') {
    checkout scm
  }

  stage('Build') {
      sh "mvn clean verify test compile"
  }

  withMaven(maven: 'MAVEN_3.8.2', jdk: 'JDK11', mavenLocalRepo: params.repository) {

      stage('SonarQube Analysis') {

        withSonarQubeEnv('sonarserver') {
          sh "${scannerHome}/bin/sonar-scanner"
        }
      }

        stage("Quality Gate"){
          timeout(time: 1, unit: 'HOURS') {
              def qg = waitForQualityGate()
              if (qg.status != 'OK') {
                  error "Pipeline aborted due to quality gate failure: ${qg.status}"
              }
          }
      }
  }

}