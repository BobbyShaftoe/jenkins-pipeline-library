

import java.string.*

repo = 'https://github.com/BobbyShaftoe/server-bootstraps-ansible.git'
//repoName = repo.replace('http.*/([a-zA-Z0-9_-]+)\\.git', 'zzz')
repoName = repo.replaceAll('.*/(.*)\\.git', '\$1')

println repoName



// Placeholder
//withEnv(['JRE_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.161-0.b14.amzn2.x86_64/jre']) {
    // some block
//}