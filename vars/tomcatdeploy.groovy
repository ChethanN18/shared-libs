def call(ip,credsid,warname,version){
  sshagent(["${credsid}"]) {
    sh "scp -o StrictHostKeyChecking=no target/${warname}-${version}.war ec2-user@${ip}:/opt/tomcat9/webapps/"
    sh "ssh ec2-user@${ip} /opt/tomcat8/bin/shutdown.sh"
    sh "ssh ec2-user@${ip} /opt/tomcat8/bin/startup.sh"
  }
}
