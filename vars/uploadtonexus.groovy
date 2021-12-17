def call(conf){
  def repoName = conf["repoName"]
  def pomfile = readMavenPom file: 'pom.xml'
  def version = pomfile.version
  def artifactID = pomfile.artifactId
  def type = pomfile.packaging
  def groupId = pomfile.groupId
  nexusArtifactUploader artifacts: [[artifactId: "${artifactID}", classifier: '', file: "target/${artifactID}-${version}.war", type: "${type}"]], credentialsId: 'nexus', groupId: "${groupId}", nexusUrl: '172.31.30.71:8081/', nexusVersion: 'nexus3', protocol: 'http', repository: "${repoName}", version: "${version}"
}
