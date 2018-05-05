def call(String repo) {

  node('aws-node-00') {
    ansiColor('xterm') {

      try {
        dir('project1') {
          stage('Checkout repository') {
            buildInfo('Checkout main repository')
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
