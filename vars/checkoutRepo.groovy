
def call(body) {
  def config = [:]
  body.resolveStrategy = Closure.DELEGATE_FIRST
  body.delegate = config
  body()

  node('aws-node-00') {
      stage('Checkout') {
          def checkoutVars = checkout scm
          echo checkoutVars

      }

  }
  //return checkoutVars
}
