def call(String repo) {

  node('aws-node-00') {
    ansiColor('xterm') {

      try {
        dir('.') {
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
