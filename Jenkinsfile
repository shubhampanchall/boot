 pipeline{
agent any
stages{
stage('Build'){
steps{
git branch:'master',url:'https://github.com/shubhampanchall/boot.git'
bat "./mvnw compile"
}
}
stage('Test'){
steps{
bat "./mvnw test"
}
}
stage('Package'){
steps{
bat "./mvnw package"
}
}
stage('Containerize'){
steps{
bat "docker build -t my-petadoption-image ."
}
}
stage('Deploy'){
steps{
bat "docker run -d -p 7070:7070 my-petadoption-image"
}
}
}
}
