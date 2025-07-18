pipeline{
    agent any
    tools {
        jdk 'jdk'
        maven 'mvn'
    }
    stages{
        stage('Passo 1'){
            steps{
                echo 'Hello world'
            }
        }
        stage('Compilar Java') {
            steps {
                script {
                    // Assumindo que os arquivos .java estão na pasta src
                  bat 'mvn clean compile'
                }
            }
        }
    }

}
