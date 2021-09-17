pipeline {
    agent any
    parameters {
        string(name: 'STATUS', defaultValue:'waiting', description: 'status to deploy')
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: 'version with choices')
        booleanParam(name: 'executeTests', defaultValue: true, description: 'description for booleanParam')
    }
    stages {
        stage("build") {
            steps {
                echo 'Building **********'
                echo "STATUS is ${params.STATUS}"
            }
        }
        stage("test") {
            when {
                expression {
                    params.executeTests
                }
            }
            steps {
                echo 'Testing **********'
            }
        }
        stage("deploy") {
            steps {
                echo 'Deploying **********'
                echo "VERSION is ${params.VERSION}"
            }
        }
    }
}
