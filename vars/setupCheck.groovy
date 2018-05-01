def call(body) {

 def config = [: ]
 body.resolveStrategy = Closure.DELEGATE_FIRST
 body.delegate = config
 body()

 node('aws-node-00') {
  // Clean workspace before doing anything
  deleteDir()

  try {
   stage('Checkout main repository') {
    buildInfo('Run the env script')
    git poll: false, url: 'https://github.com/BobbyShaftoe/pipeline-job-aa.git'
   }

   stage('List files in workspace') {
    sh 'ls -larst .'
    sh 'ls -la */*'
   }

   stage('Environment') {
    sh 'scripts/env.sh'

   }
   stage('Read placeholder') {
    readFile 'lib/placeholder.txt'
   }

   stage('Archive workspace') {
     archiveArtifacts '**/*.*'
   }

  } catch (err) {
   currentBuild.result = 'FAILED'
   throw err
  }

 }
}