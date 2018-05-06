def call(String repo) {


  node('aws-node-00') {
    ansiColor('xterm') {

      repoName = repo.replace('^.*/([a-zA-Z0-9_-]+).git', '\1')

      try {
        dir('.') {
          stage('Create repository directory'){
            sh 'mkdir -p $repoName'
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
