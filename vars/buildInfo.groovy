
def buildinfo() {
  infoBuildNumber = env.BUILD_NUMBER
  infoJobName = env.JOB_NAME
  echo "$infoBuildNumber $infoJobName"
}

def libinfo() {
  infoSharedLib = 'jenkins-pipeline-library'
  echo "$infoSharedLib"
}

