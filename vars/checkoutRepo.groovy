
def call() {

  def checkoutVars = checkout scm
  echo checkoutVars
  return checkoutVars
}
