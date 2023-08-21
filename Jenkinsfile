pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                withMaven(maven: 'mvn-3-9-4') {
                    sh 'mvn validate'
                }
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