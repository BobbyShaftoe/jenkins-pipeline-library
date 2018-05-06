def call(String repo) {

  repoName = repo.replace('^.*/([a-zA-Z0-9_-]+).git', $1)

  node('aws-node-00') {
    ansiColor('xterm') {

      try {
        dir('.') {
          stage('Create repository directory'){
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
