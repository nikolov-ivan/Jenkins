pipeline {
    agent any

    stages{
        stage(PullAndRun) {
            steps {
                git changelog: false, credentialsId: 'ServiceUser', url: 'https://github.com/nikolov-ivan/Jenkins.git'
                withMaven(globalMavenSettingsConfig: 'maven-global-settings', jdk: 'Java SE Development Kit 11', maven: 'Maven 3.6.3'){
                    sh 'mvn clean test -U -Dsurefire.suiteXmlFiles= src/test/java/xml/${xmlToRun -Denvironment=${environ}'
                }
            }
        }
    }
}