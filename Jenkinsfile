pipeline {
    agent any
    // environment {
    //     DOCKERHUB_CREDENTIALS = credentials('dockerhub')
    // }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/C-Bravo/API-REST-Calculadora'
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
        // stage('Push Docker Image') {
        //     steps {
        //         script {
        //             docker.withRegistry('https://index.docker.io/v1/', 'DOCKERHUB_CREDENTIALS') {
        //                 docker.image("tu-imagen:latest").push('latest')
        //             }
        //         }
        //     }
        // }
    }
    post {
        always {
            cleanWs()
        }
    }
}