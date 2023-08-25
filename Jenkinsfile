pipeline {
    agent any

    tools {
        maven 'mvn-3-9-4'
        jdk 'java-11'
    }

    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                    google-chrome --version
                '''
            }
        }

        stage('Test') {
            steps {
                sh 'mvn validate'
                sh 'mvn test -DappEnv=ci'
            }
        }

    }
}
