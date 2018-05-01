
def call(String stagename = '') {
  infoBuildNumber = env.BUILD_NUMBER
  infoJobName = env.JOB_NAME
  infoSharedLib = 'jenkins-pipeline-library'
  env.SHARED_LIB = $infoSharedLib
  echo "('$stagename') SharedLib: $infoSharedLib"
}

