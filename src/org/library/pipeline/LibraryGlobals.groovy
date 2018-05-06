package org.library.pipeline;



class LibraryGlobalsVars implements Serializable {

    def sharedLibName = 'jenkins-pipeline-library'
    def sharedLibVersion = '0.1'

    LibraryGlobalVars(sharedLibName, sharedLibVersion) {
      this.sharedLibName = sharedLibName
      this.sharedLibVersion = sharedLibVersion
    }

    public def libInfo() {
      printf("Shared library info:\n\tName: %s\n\tVersion: %s\n", sharedLibName, sharedLibVersion)
    }

    public def libName() {
      return sharedLibName
    }


}