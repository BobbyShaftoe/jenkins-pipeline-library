def call(node, repo) {


  node('aws-node-00') {
    ansiColor('xterm') {

      repoName = repo.replaceAll('.*/(.*)\\.git', '\$1')

      try {
        dir('.') {
          stage('Create repository directory'){
            buildInfo(repoName)
            sh "mkdir -p $repoName"
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
