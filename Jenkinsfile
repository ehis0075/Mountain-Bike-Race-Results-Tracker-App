pipeline {
  agent any
  stages {
    stage("build") {
      steps {
        sh """
          docker build -t race-result-service-docker:latest .
        """
      }
    }
    stage("remove-old") {
      steps {
        sh """
          docker rm -f race-result-service
        """
      }
    }
    stage("run") {
      steps {
        sh """
          docker run -d -p 8085:8085 -e TZ=Africa/Lagos --name race-result-service race-result-service-docker
        """
      }
    }
  }
}