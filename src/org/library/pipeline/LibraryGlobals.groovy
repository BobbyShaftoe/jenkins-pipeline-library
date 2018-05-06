package org.library.pipeline;

public def sharedLibName = 'jenkins-pipeline-library'
public def sharedLibVersion = '0.1'

//class LibraryGlobals {

    public def libInfo() {
      printf("Shared library info:\n\tName: %s\n\tVersion: %s\n", sharedLibName, sharedLibVersion)
    }

    public def libName() {
      return sharedLibName
    }


//}