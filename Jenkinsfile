pipeline {
    agent any

    tools {
        maven 'mvn-3-9-4'
        jdk 'java-11'
    }

    stages {
        stage ('Initialize') {
            steps {
                slackSend (color: "good", message: "Build started: ${env.JOB_NAME} #${env.BUILD_NUMBER}")
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                    google-chrome --version
                '''
            }
        }

        stage ('Test') {
            steps {
                slackSend (color: "good", message: "Tests started at ${env.JOB_NAME} #${env.BUILD_NUMBER}")
                sh 'mvn test -DappEnv=ci'
            }
        }

        stage ('Send Reports') {
            steps {
                slackSend (color: "good", message: "Tests done. Compressing reports: ${env.JOB_NAME} #${env.BUILD_NUMBER}")
                slackUploadFile (filePath: "./reports.zip")
                //sh zip
            }
        }

    }

    post {
        success {
            script {
                slackSend(channel: "selenium-automation", message: "my-first-pipeline-slack passed successfully")
            }
        }
    }
}
