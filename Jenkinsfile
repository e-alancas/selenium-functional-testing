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
