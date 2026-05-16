pipeline {
    agent any

    environment {
        AWS_ACCOUNT_ID = '639642129219'
        AWS_REGION = 'ap-south-1'
        ECR_REPOSITORY = 'attendance-management-system'
        IMAGE_TAG = "${BUILD_NUMBER}"
    }

    tools {
        maven 'maven'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                url: 'https://github.com/Vaibhavi049/attendance-management-system.git'
            }
        }

        stage('Build Application') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t attendance-management-system .'
            }
        }

        stage('Authenticate Docker to AWS ECR') {
            steps {
                withCredentials([[
                    $class: 'AmazonWebServicesCredentialsBinding',
                    credentialsId: 'aws-ecr-credentials'
                ]]) {

                    bat """
                    aws ecr get-login-password --region %AWS_REGION% | docker login --username AWS --password-stdin %AWS_ACCOUNT_ID%.dkr.ecr.%AWS_REGION%.amazonaws.com
                    """
                }
            }
        }

        stage('Tag Docker Image') {
            steps {
                bat """
                docker tag attendance-management-system:latest %AWS_ACCOUNT_ID%.dkr.ecr.%AWS_REGION%.amazonaws.com/%ECR_REPOSITORY%:%IMAGE_TAG%
                """
            }
        }

        stage('Push Docker Image to ECR') {
            steps {
                bat """
                docker push %AWS_ACCOUNT_ID%.dkr.ecr.%AWS_REGION%.amazonaws.com/%ECR_REPOSITORY%:%IMAGE_TAG%
                """
            }
        }

         stage('Trigger CD Pipeline') {
                steps {
                    build job: 'attendance-management-cd',
                    parameters: [
                        string(name: 'BUILD_NUMBER', value: "${BUILD_NUMBER}"),
                        string(name: 'ENVIRONMENT', value: "Staging")
                    ]
                }
            }
    }




    post {
        success {
            emailext(
                subject: "CI Pipeline Success - Build #${BUILD_NUMBER}",
                body: """
                    Build Successful!

                    Job Name: ${JOB_NAME}
                    Build Number: ${BUILD_NUMBER}

                    Docker Image pushed to ECR successfully.
                """,
                to: "yourgmailid2@gmail.com"
            )
        }

        failure {
            emailext(
                subject: "CI Pipeline Failed - Build #${BUILD_NUMBER}",
                body: """
                    Build Failed!

                    Job Name: ${JOB_NAME}
                    Build Number: ${BUILD_NUMBER}

                    Check Jenkins console logs for details.
                """,
                to: "yourgmailid2@gmail.com"
            )
        }
    }
}