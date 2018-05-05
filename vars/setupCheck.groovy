def call(body) {

  def config = [: ]
  body.resolveStrategy = Closure.DELEGATE_FIRST
  body.delegate = config
  body()
  def nodeName = 'aws-node-00'

  node("$nodeName") {
    ansiColor('xterm') {

      try {

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
