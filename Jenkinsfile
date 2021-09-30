pipeline {
    agent any
    environment {
        FOO = "bar"
    }
    parameters {
        choice(name: 'buildTool', choices: ['maven', 'gradle',FOO], description: 'Build tool with choices')
        booleanParam(name: 'cleanBeforeBuild', defaultValue: true, description: 'Clean before build')
    }
    stages {
        stage("Initial configuration") {
            steps {
                echo 'Building stage **********'
                echo "Build tool is ${params.buildTool}"
                echo "Clean project before build status is: ${params.cleanBeforeBuild}"
            }
        }
        script {
            if (buildTool.equals("gradle")) {
                stage("Clean project with gradle") {
                    when {
                        expression {
                            params.cleanBeforeBuild
                        }
                    }
                    steps {
                        echo 'Cleaning starts **********'
                        sh 'gradle clean'
                        echo 'Cleaning completed ******'
                    }
                }
                stage("Build with gradle") {
                    steps {
                        echo 'Building starts **********'
                        sh 'gradle build'
                        echo 'Building completed ******'
                    }
                }
            }
            if (buildTool.equals("maven")) {
                stage("Clean project with maven") {
                    when {
                        expression {
                            params.cleanBeforeBuild
                        }
                    }
                    steps {
                        echo 'Cleaning starts **********'
                        sh 'maven clean'
                        echo 'Cleaning completed ******'
                    }
                }
                stage("Build with gradle") {
                    steps {
                        echo 'Building starts **********'
                        sh 'maven install'
                        echo 'Building completed ******'
                    }
                }
            }
        }    
    }
}
