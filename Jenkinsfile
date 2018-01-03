pipeline {
  agent any
  stages {
    stage('Pull') {
      steps {
        git(url: 'https://github.com/SakinaZilat/AlmarssadPro.git', branch: 'master', changelog: true)
      }
    }
  }
}