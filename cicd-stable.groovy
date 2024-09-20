node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/kotlinport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/kotlinport.git'), string(name: 'PORT_DESCRIPTION', value: 'Kotlin is an open-source, statically typed programming language supported and developed by JetBrains and open-source contributors.' ), string(name: 'BUILD_LINE', value: 'STABLE') ]
  }
}
