
def call(String stagename = '') {
  infoBuildNumber = env.BUILD_NUMBER
  infoJobName = env.JOB_NAME
  infoSharedLib = 'jenkins-pipeline-library'
  echo "[$stagename] Using shared lib: $infoSharedLib"
}

