

def call(String stagename = '') {
  infoSharedLib = 'jenkins-pipeline-library'

  infoBuildNumber = env.BUILD_NUMBER
  infoJobName = env.JOB_NAME
  env.SHARED_LIB = infoSharedLib
  echo "[Pipeline] \u001B[31mStage('$stagename')\u001B[0m SharedLib: \u001B[35m$infoSharedLib\u001B[0m"
}

