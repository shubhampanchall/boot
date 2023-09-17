pipeline {
    agent any
  
    stages {
        stage('Build') {
            steps {
                script {
                    // Clone the Git repository
                    checkout([$class: 'GitSCM', branches: [[name: 'master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'shubhampanchall', url: 'https://github.com/shubhampanchall/boot.git']]])
                    
                    // Compile the project
                    sh './mvnw compile'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    // Run tests
                    sh './mvnw test'
                }
            }
        }
        stage('Package') {
            steps {
                script {
                    // Package the application
                    sh './mvnw package'
                }
            }
        }
        stage('Containerize') {
            steps {
                script {
                    // Build the Docker image
                    sh 'docker build -t my-petadoption-image .'
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    // Run the Docker container
                    sh 'docker run -d -p 7070:7070 my-petadoption-image'
                }
            }
        }
    }
}
