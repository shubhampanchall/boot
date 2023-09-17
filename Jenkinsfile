pipeline {
    agent any
    stages {
        stage('Set Execute Permissions') {
            steps {
                sh 'chmod +x ./mvnw'
            }
        }
        stage('Build') {
            steps {
                git branch: 'master', url: 'https://github.com/shubhampanchall/boot.git'
                sh './mvnw compile'
            }
        }
        stage('Test') {
            steps {
                sh './mvnw test'
            }
        }
        stage('Package') {
            steps {
                sh './mvnw package'
            }
        }
        stage('Containerize') {
            steps {
                sh 'docker build -t my-petadoption-image .'
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker run -d -p 7070:7070 my-petadoption-image'
            }
        }
    }
}
