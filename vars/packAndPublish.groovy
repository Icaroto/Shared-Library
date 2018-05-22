#!groovy
package org.basic;

def call(Map config) {
    node {
        stage ('Get Source Code') {
          log.info 'TESTING USING LIBRARY'
          echo "This is the first variable ${config.first}"
        }

        stage('Initialize') {
          
          echo "This is the second variable ${config.second}"
        }

        stage('Question') {
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

