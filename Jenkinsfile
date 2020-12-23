pipeline {
    agent any

    options {
            timeout(time: 5, unit: 'MINUTES')
        }

    stages {
        stage("Build") {
            steps {
                script{
                    sh 'echo "hola mundo" '
                }
            }
        }
    }
}