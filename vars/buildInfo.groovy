

def call(String stagename = '') {
  infoSharedLib = 'jenkins-pipeline-library'

  infoBuildNumber = env.BUILD_NUMBER
  infoJobName = env.JOB_NAME
  env.SHARED_LIB = infoSharedLib
  echo "\u001B[32m[Pipeline] Stage ('$stagename') SharedLib: $infoSharedLib\u001B[0m"
}

