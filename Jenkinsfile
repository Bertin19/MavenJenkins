node {
  stage('SCM') {
    checkout scm
  }

  withMaven(maven: 'MAVEN_3.8.2', jdk: 'JDK11', mavenLocalRepo: params.repository) {

      stage('SonarQube Analysis') {

        withSonarQubeEnv('SonarQube') {
          sh "mvn clean test verify sonar:sonar"
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