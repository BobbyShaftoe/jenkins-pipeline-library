import com.thoughtworks.xstream.converters.basic.StringBufferConverter

def call(String repo, String repo_dir) {

    nodeName = env.JOB_NODE_NAME

    node("$nodeName") {

        ansiColor('xterm') {

            repoName = repo.replaceAll('.*/(.*)\\.git', '\$1')
            repoDir = repo_dir

            try {

                dir('.') {
                    stage('Create repository directory') {
                        buildInfo(repoName)
                        sh "mkdir -p $repoDir/$repoName"
                    }
                }

                dir("$repoDir/$repoName") {
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
