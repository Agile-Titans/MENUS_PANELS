pipeline {
    agent any

    environment {
        SONAR_TOKEN = credentials('sonar-token')
    }

    tools {
        maven 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Unit Test') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Code Quality Analysis') {
            steps {
                bat 'mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.token=%SONAR_TOKEN%'
            }
        }

        stage('Deploy to Staging') {
            steps {
                echo 'All stages passed! Deploying to staging environment...'
                echo 'Deployment successful!'
            }
        }
    }

    post {
        failure {
            mail to: 'abdiyow587@gmail.com',
                 subject: "Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "The build ${env.JOB_NAME} #${env.BUILD_NUMBER} has failed. Please check Jenkins for details."
        }
        success {
            echo 'Pipeline completed successfully!'
        }
    }
}