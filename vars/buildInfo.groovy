

def call(String messageString = '') {
  infoSharedLib = 'jenkins-pipeline-library'

  infoBuildNumber = env.BUILD_NUMBER
  infoJobName = env.JOB_NAME
  stageName = env.STAGE_NAME
  env.SHARED_LIB = infoSharedLib

  echo "[Pipeline] \u001B[31mStage("$stageName")\u001B[0m \""$messageString"\" \u001B[35mSharedLib: \"$infoSharedLib\u001B[0m\""
}

