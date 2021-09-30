pipeline {
    agent any
    tools {
        gradle "Gradle_Local"
    }
    environment {
        gradle = "gradle"
        maven = "maven"
    }
    parameters {
        choice(name: 'buildTool', choices: ['maven', 'gradle'], description: 'Build tool with choices')
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
        stage ('Main Stage') {
            steps {
                script {
                    if (buildTool.equals(env.gradle)) {
                        stage("Clean project with gradle") {
                            if (cleanBeforeBuild == true) {
                                echo 'Cleaning starts **********'
                                sh 'gradle --version'
                                echo 'Cleaning completed ******'
                            } else {
                                echo 'No cleaning before build has been chosen'
                            }
                        }
                        stage("Build with gradle") {
                            sh 'gradle --version'
                        }
                    }
                    if (buildTool.equals(env.maven)) {
                        stage ('Stage 2') {
                            sh "echo Stage 2222222 ${params.cleanBeforeBuild}"
                        }
                    }
                }
            }
        }
    }
}
