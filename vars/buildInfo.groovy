

def call(String message = '') {
  infoSharedLib = 'jenkins-pipeline-library'

  infoBuildNumber = env.BUILD_NUMBER
  infoJobName = env.JOB_NAME
  env.SHARED_LIB = infoSharedLib
  echo "[Pipeline] \u001B[31mStage('env.STAGE_NAME')\u001B[0m \""$message"\" \u001B[35mSharedLib: \"$infoSharedLib\u001B[0m\""
}

