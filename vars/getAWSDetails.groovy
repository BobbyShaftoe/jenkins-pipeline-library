def call() {
    buildInfo()
    az = sh(returnStdout: true, script: 'curl -s http://169.254.169.254/latest/meta-data/placement/availability-zone').trim()
    region = az.replaceFirst(/[a-z]$/, "")
    account = sh(returnStdout: true, script: 'curl -s http://169.254.169.254/latest/dynamic/instance-identity/document | grep -oP \'(?<="accountId" : ")[^"]*(?=")\'').trim()

    return ["az": az, "region": region, "account": account]
}
