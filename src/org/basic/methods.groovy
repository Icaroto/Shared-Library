#!groovy
package org.basic;

def checkOutFrom(branch) {
  checkout([
		$class: 'GitSCM',
    url: "https://github.com/Icaroto/Jenkins.git",
		branches: [[name: "*/${branch}"]], 
		extensions: scm.extensions + [[$class: 'CleanCheckout']],
		userRemoteConfigs: scm.userRemoteConfigs
		])
		echo "Retrieved $env.BRANCH_NAME in workspace: $env.WORKSPACE"
}

return this