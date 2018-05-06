

def call(String messageString = '') {
    infoSharedLib = 'jenkins-pipeline-library'

    infoBuildNumber = env.BUILD_NUMBER
    infoJobName = env.JOB_NAME
    stagename = env.STAGE_NAME
    env.SHARED_LIB = infoSharedLib

    if (messageString != '') {
        messageString = '\"' + messageString + '\" '
    }

    echo "\u001B[34mWorkspace: \"$env.WORKSPACE\u001B[0m\""
    echo "\u001B[31mStage('$stagename')\u001B[0m $messageString\u001B[35m\"$infoSharedLib\u001B[0m\""
}

