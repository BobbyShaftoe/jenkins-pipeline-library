def call(body) {

  def config = [: ]
  body.resolveStrategy = Closure.DELEGATE_FIRST
  body.delegate = config
  body()

  node('aws-node-00') {
    ansiColor('xterm') {
      // Clean workspace before doing anything
      //deleteDir()

      try {
       stage('Checkout main repository') {
        buildInfo('Checkout main repository')
        //git poll: false, url: 'https://github.com/BobbyShaftoe/pipeline-job-aa.git'
        sh 'echo "not checking out here"'
       }

       stage('List files in workspace') {
        buildInfo('List files in workspace')
        sh 'ls -larst .'
        sh 'ls -la */*'
       }

       stage('Environment') {
        buildInfo('Environment')
        sh 'scripts/env.sh'

       }
       stage('Read placeholder') {
        buildInfo('Read placeholder')
        readFile 'lib/placeholder.txt'
       }

       stage('Archive workspace') {
         buildInfo('Archive workspace')
         archiveArtifacts '**/*.*'
       }

      } catch (err) {
       currentBuild.result = 'FAILED'
       throw err
      }
    }
  }
}
