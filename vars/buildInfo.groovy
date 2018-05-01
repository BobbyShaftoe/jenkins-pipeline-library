
infoSharedLib = 'jenkins-pipeline-library'


def call(String stagename = '') {
  infoBuildNumber = env.BUILD_NUMBER
  infoJobName = env.JOB_NAME
  env.SHARED_LIB = infoSharedLib
  echo "('$stagename') SharedLib: $infoSharedLib"
}

