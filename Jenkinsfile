pipeline {
    agent any

    environment {
        registry = 'carlosbravorev/api-rest-calculator'
        registryCredentials = 'DockerHubCredentials'
    }


    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/C-Bravo/API-REST-Calculator'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Static Code Analysis') {
            steps {
                withSonarQubeEnv('SonarQube Server') {
                    sh 'mvn sonar:sonar'
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("api-rest-calculadora:latest")
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                    docker.withRegistry('https://index.docker.io/v1/', registryCredentials) {
                        dockerImage.push()
                    }
                }
            }
        }
    }
    post {
        always {
            cleanWs()
        }
    }
}