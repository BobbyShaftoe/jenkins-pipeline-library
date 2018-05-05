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
          buildInfo()
          sh 'ls -larst .'
          sh 'ls -la */*'
       }

        stage('Environment') {
          buildInfo()
          sh 'scripts/env.sh'

         }
        stage('Read placeholder') {
          buildInfo()
          readFile 'lib/placeholder.txt'
         }

        stage('Archive workspace') {
           buildInfo()
           archiveArtifacts '**/*.*'
         }

      } catch (err) {
          currentBuild.result = 'FAILED'
          throw err
      }
    }
  }
}
