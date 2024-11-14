pipeline {
    agent any

    tools {
        maven "Maven"  // Ensure Maven is configured in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from GitHub repository
                git 'https://github.com/Spiderman-boo/Project-S.git'
            }
        }

        stage('Run TestNG Suite') {
            steps {
                // Run Maven to execute the TestNG suite
                bat "mvn -Dmaven.test.failure.ignore=true clean test -DsuiteXmlFile=TestSuite/testng.xml"
            }

            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'  // Record test results
                    archiveArtifacts 'target/*.jar'  // Archive the jar files
                }
                failure {
                    echo 'Tests failed'
                }
            }
        }
    }
}
