pipeline {
    agent any
    tools {
        gradle "Gradle_Local"
        maven "Maven_Local"
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
                            if (params.cleanBeforeBuild && params.cleanBeforeBuild == 'true') {
                                echo 'Cleaning starts **********'
                                sh 'gradle clean'
                                echo 'Cleaning completed ******'
                            } else {
                                echo 'No cleaning before build has been chosen'
                            }
                        }
                        stage("Build with gradle") {
                            sh 'gradle build'
                        }
                    }
                    if (buildTool.equals(env.maven)) {
                        stage("Clean project with maven") {
                            if (params.cleanBeforeBuild && params.cleanBeforeBuild == 'true') {
                                echo 'Cleaning starts **********'
                                sh 'mvn clean'
                                echo 'Cleaning completed ******'
                            } else {
                                echo 'No cleaning before build has been chosen'
                            }
                        }
                        stage("Build with maven") {
                            sh 'mvn install'
                        }
                    }
                }
            }
        }
    }
}
