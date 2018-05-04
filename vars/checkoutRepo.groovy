def call(String repo) {

  node('aws-node-00') {
    ansiColor('xterm') {

      try {
       stage('Checkout main repository') {
        buildInfo('Checkout main repository')
          git poll: false, url: repo
       }

      } catch (err) {
         currentBuild.result = 'FAILED'
         throw err
      }
    }
  }
}
