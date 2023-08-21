pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                withMaven {
                    sh 'mvn validate'
                }
            }
        }
        stage('Test') {
            steps {
                withMaven {
                    sh 'mvn test'
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}