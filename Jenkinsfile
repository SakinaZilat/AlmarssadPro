pipeline {
  agent any
  stages {
    stage('Pull') {
      steps {
      	echo 'Pulling..'
        git(url: 'https://github.com/SakinaZilat/AlmarssadPro.git', branch: 'master', changelog: true)
      }
    }
    stage('Test') {
      steps {
          echo 'Testing..'
      }
    }
    stage('Deploy') {
       steps {
          echo 'Deploying....'
       }
    }
  }
}