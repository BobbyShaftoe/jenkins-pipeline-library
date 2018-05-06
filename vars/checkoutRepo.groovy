def call(String repo) {

    nodeName = env.JOB_NODE_NAME
    thisWorkSpace = env.THIS_WORKSPACE

    node("$nodeName") {
        ansiColor('xterm') {

            customWorkspace thisWorkSpace
            repoName = repo.replaceAll('.*/(.*)\\.git', '\$1')

            try {
                dir('.') {
                    stage('Create repository directory') {
                        buildInfo(repoName)
                        sh "mkdir -p $repoName"
                    }
                }
                dir('.') {
                    stage('Checkout repository') {
                        buildInfo("$repo")
                        git poll: false, url: repo
                    }
                }

            } catch (err) {
                currentBuild.result = 'FAILED'
                throw err
            }
        }
    }
}
