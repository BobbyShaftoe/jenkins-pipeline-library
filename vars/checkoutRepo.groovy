def call(String repo) {


  node('aws-node-00') {
    ansiColor('xterm') {

      repoName = repo.replaceAll('.*/(.*)\\.git', '\$1')
      println repoName

      try {
        dir('.') {
          stage('Create repository directory'){
            echo repoName
            sh 'mkdir $repoName'
            sh 'echo > $repoName/test.txt'
          }
        }
        dir($repoName) {
          stage('Checkout repository') {
            buildInfo("$repo")
            git poll: false, url: repo
          }
        }

      } catch (err) {
         currentBuild.result = 'FAILED'
         throw err
      }
    }
  }
}
