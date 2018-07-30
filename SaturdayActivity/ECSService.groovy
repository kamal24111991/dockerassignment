mavenJob('BuildApp') {
  
  scm 
  {
    git
     {
      remote
       {
         url('https://github.com/kamal24111991/ContinuousIntegration.git')
        }
       branch('master')
      }
     }

 

    
  goals('install') 
       rootPOM("Spring3HibernateApp/pom.xml")
        mavenInstallation('Maven3.5.3')

 postBuildSteps
  {
	shell('''
	  
#!/bin/bash

cd /var/lib/jenkins/workspace/BuildApp/
docker build -t tomcat .
COMMAND="$(aws ecr get-login --no-include-email --region us-east-1)"
eval $COMMAND
docker tag tomcat:latest 842183492103.dkr.ecr.us-east-1.amazonaws.com/tomcat:latest
docker push 842183492103.dkr.ecr.us-east-1.amazonaws.com/tomcat:latest
aws ecs register-task-definition --cli-input-json file://task.json
aws ecs create-service --cluster ECSCluster --service-name springApp --task-definition webserver --desired-count 3 --deployment-configuration maximumPercent=200,minimumHealthyPercent=50
aws ecs update-service --cluster ECSCluster --service springApp --task-definition webserver''')
	  
	  
  }
}
