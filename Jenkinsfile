pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    try {
                        // Clone the Git repository
                        checkout([$class: 'GitSCM', branches: [[name: 'master']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'CleanBeforeCheckout']], userRemoteConfigs: [[credentialsId: 'shubhampanchall', url: 'https://github.com/shubhampanchall/boot.git']]])

                        // Compile the project
                        bat './mvnw compile'
                    } catch (Exception e) {
                        currentBuild.result = 'FAILURE'
                        error("Build failed: ${e.message}")
                    }
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // Run tests
                    bat './mvnw test'
                }
            }
        }

        stage('Package') {
            steps {
                script {
                    // Package the application
                    bat './mvnw package'
                }
            }
        }

        stage('Containerize') {
            steps {
                script {
                    // Build the Docker image
                    bat 'docker build -t my-petadoption-image .'
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Run the Docker container
                    bat 'docker run -d -p 7070:7070 my-petadoption-image'
                }
            }
        }
    }
}
