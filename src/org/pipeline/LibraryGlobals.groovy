//package src.org.aws.library.pipeline.LibraryGlobals
package org.pipeline

env.sharedLibName = 'jenkins-pipeline-library'
env.sharedLibVersion = '0.1'
env.BUILD_DIR = 'BUILD'

//class LibraryGlobalsVars implements Serializable {
//
//    env.sharedLibName = 'jenkins-pipeline-library'
//    env.sharedLibVersion = '0.1'
//
//    LibraryGlobalVars(sharedLibName, sharedLibVersion) {
//      this.sharedLibName = sharedLibName
//      this.sharedLibVersion = sharedLibVersion
//    }
//
//    public def libInfo() {
//      printf("Shared library info:\n\tName: %s\n\tVersion: %s\n", sharedLibName, sharedLibVersion)
//    }
//
//    public def libName() {
//      return sharedLibName
//    }
//
//
//}