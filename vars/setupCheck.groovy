def call(body) {

    def config = [: ]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    nodeName = env.JOB_NODE_NAME

    node("$nodeName") {
        ansiColor('xterm') {

            try {

                stage('CWD') {
                    buildInfo()
                    sh "pwd"

                }

                stage('List files in workspace') {
                    buildInfo()
                    sh 'ls -larst .'
                    sh 'ls -la */*'
                }

                stage('Environment') {
                    buildInfo()
                    sh 'scripts/env.sh'

                }
//                stage('Read placeholder') {
//                    buildInfo()
//                    readFile 'lib/placeholder.txt'
//                }

                stage('Archive workspace') {
                    buildInfo()
                    archiveArtifacts '**/*.*'
                }

            } catch (err) {
                currentBuild.result = 'FAILED'
                throw err
            }
        }
    }
}