node {
  stage('SCM') {
    checkout scm
  }

  withMaven(maven: 'MAVEN_3.8.2', jdk: 'JDK11', mavenLocalRepo: params.repository) {
      stage("Clean Up") {
          echo "********** CLEAN ************"
          sh "mvn clean"
          sh "ls -la"
      }

      stage('SonarQube Analysis') {

        withSonarQubeEnv() {
              sh "sonar:sonar"
            }
      }
  }

}