pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                withMaven() {
                    sh 'mvn clean verify'
                }
            }
        }
        stage('Test') {
            steps {
                withMaven() {
                    echo 'testing....'
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
