#!groovy
package org.basic;

def call(Map config) {
    node {
        stage ('Testing') {
          echo "This is the first variable ${config.first}"
        }

        stage('Another') {
          
          echo "This is the second variable ${config.second}"
        }

        stage('Way') {
            try {			
              timeout(time:3, unit:'DAYS') {
                input message:'Here comes the boom?', submitterParameter: 'approvedBy'
                currentBuild.description = "YES"
              }
            } catch (err) {
              currentBuild.description = "NO :("
              currentBuild.result = "ABORTED"
            }
        }
    }
}

// def call(Map config) {
//     node {
//         git url: "https://github.com/jenkinsci/${config.name}-plugin.git"
//         sh 'mvn install'
//         mail to: '...', subject: "${config.name} plugin build", body: '...'
//     }
// }

