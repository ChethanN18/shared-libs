def call(conf){
 def reponame = conf["reponame"]
 def groupId = pomfile.groupId
 def type = pomfile.packaging
 def artifactID = pomfile.artifactId
 def version = pomfile.version
 def pomfile = readMavenPom file: 'pom.xml'
nexusArtifactUploader artifacts: [[artifactId: "${artifactID}", classifier: '', file: "target/${art}ifactID}-${version}.war", type: "${type}"]], credentialsId: 'nexus', groupId: "${groupId}", nexusUrl: '172.31.30.71:8081/', nexusVersion: 'nexus3', protocol: 'http', repository: "${reponame}", version: "${version}"
}
