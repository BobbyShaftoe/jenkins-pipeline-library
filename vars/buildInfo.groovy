def call(body) {

 def config = [: ]
 body.resolveStrategy = Closure.DELEGATE_FIRST
 body.delegate = config
 body()

  node('aws-node-00') {
    try {

        stage('Version Info') {
          infoBuildNumber = env.BUILD_NUMBER
          infoJobName = env.JOB_NAME
          infoSharedLib = 'jenkins-pipeline-library'
          echo "$infoSharedLib:$infoBuildNumber:$infoJobName"
        }

    } catch (err) {
   currentBuild.result = 'FAILED'
   throw err
    }
  }
}


