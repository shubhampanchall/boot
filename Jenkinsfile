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
                git branch: 'master', url: 'https://github.com/shubhampanchall/petadoption.git'
                withEnv([
                    "MAVEN_HOME=/usr/bin/maven-3.6.3", // Use the path to your Maven installation
                    "PATH+MAVEN_HOME/bin"
                ]) {
                    sh './mvnw compile'
                }
            }
        }
        stage('Test') {
            steps {
                withEnv([
                    "MAVEN_HOME=/usr/bin/maven-3.6.3", // Use the path to your Maven installation
                    "PATH+MAVEN_HOME/bin"
                ]) {
                    sh './mvnw test'
                }
            }
        }
        stage('Package') {
            steps {
                withEnv([
                    "MAVEN_HOME=/usr/bin/maven-3.6.3", // Use the path to your Maven installation
                    "PATH+MAVEN_HOME/bin"
                ]) {
                    sh './mvnw package'
                }
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