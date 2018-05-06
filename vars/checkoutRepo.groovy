def call(String repo) {

    nodeName = env.JOB_NODE_NAME
    println env.THIS_WORKSPACE

    node("$nodeName") {
        ansiColor('xterm') {

            repoName = repo.replaceAll('.*/(.*)\\.git', '\$1')
            println env.THIS_WORKSPACE

            try {
                dir("$env.THIS_WORKSPACE") {
                    stage('Create repository directory') {
                        buildInfo(repoName)
                        sh "mkdir -p $repoName"
                    }
                }
                dir("$env.THIS_WORKSPACE") {
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
