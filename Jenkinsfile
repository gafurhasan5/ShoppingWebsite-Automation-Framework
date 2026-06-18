pipeline {
    agent any

    tools {
        maven 'Maven-3.9.16'
        jdk 'JDK-11'
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

        // ✅ 1. Checkout
        stage('Checkout Code') {
            steps {
                git branch: 'master',
                url: 'https://github.com/gafurhasan5/ShoppingWebsite-Automation-Framework.git'
            }
        }

        // ✅ 2. Build
        stage('Build Project') {
            steps {
                sh 'mvn clean compile'
            }
        }

        // ✅ 3. Run TestNG
        stage('Run Automation Tests') {
            steps {
                sh """
                mvn test \
                -DsuiteXmlFile=${SUITE_FILE} \
                -Dbrowser=${params.BROWSER} \
                -Denv=${params.ENV} \
                -DisHeadless=${params.HEADLESS}
                """
            }
        }

        // ✅ 4. Publish JUnit Results
        stage('Publish Results') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }

        // ✅ 5. Archive Reports (IMPORTANT for Extent)
        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: '''
                    **/screenshots/*.png,
                    **/logs/*.log,
                    **/test-output/**/*.*,
                    **/ExtentReports/*.html
                ''',
                allowEmptyArchive: true
            }
        }
    }

    // ✅ ✅ EMAIL SECTION
    post {

        success {
            emailext(
                subject: "✅ SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
                <h2>✅ Build Passed</h2>

                <p><b>Job:</b> ${env.JOB_NAME}</p>
                <p><b>Build No:</b> ${env.BUILD_NUMBER}</p>
                <p><b>Browser:</b> ${params.BROWSER}</p>
                <p><b>Environment:</b> ${params.ENV}</p>

                <p>🔗 <a href="${env.BUILD_URL}">Click here to open Jenkins</a></p>
                """,
                to: "${EMAIL_TO}",
                mimeType: 'text/html'
            )
        }

        failure {
            emailext(
                subject: "❌ FAILURE: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
                <h2>❌ Build Failed</h2>

                <p><b>Job:</b> ${env.JOB_NAME}</p>
                <p><b>Build No:</b> ${env.BUILD_NUMBER}</p>
                <p><b>Browser:</b> ${params.BROWSER}</p>

                <p>🔗 <a href="${env.BUILD_URL}">Check Failure</a></p>
                """,
                to: "${EMAIL_TO}",
                mimeType: 'text/html',
                attachLog: true,
                attachmentsPattern: '**/screenshots/*.png, **/ExtentReports/*.html'
            )
        }

        always {
            cleanWs()
        }
    }
}
