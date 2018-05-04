
def call(String repo) {

  def checkoutVars = checkout scm
  echo checkoutVars
  return checkoutVars
}
