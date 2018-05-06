
def sharedLibName = 'jenkins-pipeline-library'
def sharedLibVersion = '0.1'


def libInfo() {
  printf("Shared library info:\n\tName: %s\n\tVersion: %s\n", sharedLibName, sharedLibVersion)
}

def libName() {
  return sharedLibName
}



