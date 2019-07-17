def call(String repo, String repo_dir) {

    nodeName = env.JOB_NODE_NAME

    node("$nodeName") {

        ansiColor('xterm') {

            repoName = repo.replaceAll('.*/(.*)\\.git', '\$1')

            try {

                dir('.') {
                    stage('Create repository directory') {
                        buildInfo(repoName)
                        sh "mkdir -p $repo_dir/$repoName"
                    }
                }

                dir("$repo_dir/$repoName") {
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
