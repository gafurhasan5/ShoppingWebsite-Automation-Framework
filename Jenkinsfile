pipeline {
    agent any
    
triggers {
       // cron('H/5 * * * *')
    githubPush()
    }

    tools {
        maven 'Maven-3.9'
    }

    options {
        timestamps()
        disableConcurrentBuilds()
        retry(2)
    }

    parameters {
        choice(name: 'BROWSER', choices: ['chrome', 'firefox'], description: 'Browser')
        choice(name: 'ENV', choices: ['qa', 'stage'], description: 'Environment')
        booleanParam(name: 'HEADLESS', defaultValue: true, description: 'Headless Mode')
    }

    environment {
        SUITE_FILE = 'testng.xml'
        EMAIL_TO = 'rehankhan56390@gmail.com'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/gafurhasan5/ShoppingWebsite-Automation-Framework.git'
            }
        }

        stage('Build Project') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Automation Tests') {
            steps {
                bat """
                mvn test ^
                -DsuiteXmlFile=${SUITE_FILE} ^
                -Dbrowser=${params.BROWSER} ^
                -Denv=${params.ENV} ^
                -DisHeadless=${params.HEADLESS}
                """
            }
        }

        stage('Publish Results') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: '''
                    **/screenshots/*.png,
                    **/logs/*.log,
                    **/test-output/**/*.*,
                    **/ExtentReports/*.html
                ''', allowEmptyArchive: true
            }
        }
    }

    post {

        success {
            emailext(
                subject: "✅ SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "Build Passed ✅ 👉 ${env.BUILD_URL}",
                to: "${EMAIL_TO}"
            )
        }

        failure {
            emailext(
                subject: "❌ FAILURE: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "Build Failed ❌ 👉 ${env.BUILD_URL}",
                to: "${EMAIL_TO}",
                attachLog: true,
                attachmentsPattern: '**/screenshots/*.png'
            )
        }

        always {
            cleanWs()
        }
    }
}
