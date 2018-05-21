#! groovy
package org.basic;

def checkOutFrom(repo) {
  git url: "git@github.com:Icaroto/${repo}"
}

return this