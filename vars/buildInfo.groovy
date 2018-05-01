
def call(String version = '') {
  infoBuildNumber = env.BUILD_NUMBER
  infoJobName = env.JOB_NAME
  infoSharedLib = 'jenkins-pipeline-library'
  echo "  Using shared lib: $infoSharedLib"
}

