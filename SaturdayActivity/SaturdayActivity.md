Task:
--------
Docker Activity
----------------

1) Create ECS Cluster
2) Use Spring3Hibernate Application
3) Create service in ECS
    Configuration of Task definition
    - Minimum 3 services should be running
    - Memory : 512 mb
    - CPU : 256
    
 Setup CI/CD on ECS for java application
 ---------------------------------
 
 - Maven jenkins job for build artifact.
 - update docker image
 - push docker image to ECS repository
 - Create Task Definition and service update.
 - Manage deployement strategy for ECS service.
 
 
 Solution:
 ---------
 
Activity performing without jenkins plugins ECR and docker build image.
------------------------
           Job dsl link : https://github.com/kamal24111991/dockerassignment/blob/master/SaturdayActivity/ECSService.groovy
           
          Step 1: Create application Spring3HibernateApp.war 
          Step 2: Configure Aws access and secret keys on that system where your application is builing( In my case, I have build on jenkins server)
          Step 3: Docker engine should be intalled on your system. It is recommended to build docker image.
          Step 4: In jenkins job select post build shell section.
                 
                 Here,i have executed multiple commands like.
                 - To login into AWS ECS service.
                 - Build docker image.
                 - Push image to AWS ECR repository.
                 - Registered a task definitions with above given configurations.
                 - In the final step created a service in ECS cluster and update this service.
                 
                 
                 
           
 
 Activity performing with Amazon ECR plugin and the Cloudbees Docker build and publish plugin. 
 ------------------
 You use the Amazon ECR plugin to push Docker images to an Amazon ECR repository. You use the Cloudbees Docker build and publish plugin to build Docker images.
 
Prerequisites:- These softwares must be installed on Jenkins machine.
--------------------
- Python
- AWS CLI.
- jq– a command-line utility for parsing JSON output.
- Git command line tools– used to clone and push files to and from GitHub repositories.
- Docker
- for configuring AWS CLI, Create IAM user in AWS console & Create AWS access key ID and AWS secret key ID.

Step 1: Create an ECR Registry:-
------------

Create an Amazon ECR registry by running the following command:

aws ecr create-repository — repository-name <Repo_Name> — region <region_Name>

Verify that you can log in to the repository you created

#aws ecr get-login

Step 2: Configure Jenkins
---------------------------

In this step you will create a Jenkins Freestyle project to automate the tasks in your pipeline.

Create a freestyle project in Jenkins.

under the source code management heading, choose the git button.

In the repository URL field, type the name of your GitHub repository, e.g., https://github.com/<repo>.git.

In Credentials, choose the GitHub credentials you created in step 1 of this procedure.

Under build triggers, choose Build when a change is pushed to GitHub.

Step 3:
-------
Scroll to the build section, and then choose Add a build step.

Choose Execute shell.

In the command field, type or paste the following text:

#!/bin/bash
DOCKER_LOGIN=`aws ecr get-login — region <region_name>`
${DOCKER_LOGIN}

Step 4:
-------
Choose Add a build step, and then choose Docker Build and Publish.

In the repository name field, type the name of your ECR repository.

In the tag field, enter v_$BUILD_NUMBER.

In Docker registry URL, type the URL of your Docker registry. Use only the fully qualified domain name (FQDN) of the ECR repository you created earlier in Create an ECR Registry.

Step 5:
------
Click Add a build step.

Choose execute shell.

In the command field, type or paste the following text. Be sure to replace <Repo_Name> and <cluster_name> with the appropriate values from your environment:

#!/bin/bash
#Constants

REGION=<region_name>
REPOSITORY_NAME=<Repo_Name>
CLUSTER=<cluster_name>
FAMILY=`sed -n ‘s/.*”family”: “\(.*\)”,/\1/p’ taskdef.json`
NAME=`sed -n ‘s/.*”name”: “\(.*\)”,/\1/p’ taskdef.json`
SERVICE_NAME=${NAME}-service

#Store the repositoryUri as a variable
REPOSITORY_URI=`aws ecr describe-repositories — repository-names ${REPOSITORY_NAME} — region ${REGION} | jq .repositories[].repositoryUri | tr -d ‘“‘`

#Replace the build number and respository URI placeholders with the constants above
sed -e “s;%BUILD_NUMBER%;${BUILD_NUMBER};g” -e “s;%REPOSITORY_URI%;${REPOSITORY_URI};g” taskdef.json > ${NAME}-v_${BUILD_NUMBER}.json

#Register the task definition in the repository
aws ecs register-task-definition — family ${FAMILY} — cli-input-json file://${WORKSPACE}/${NAME}-v_${BUILD_NUMBER}.json — region ${REGION}
SERVICES=`aws ecs describe-services — services ${SERVICE_NAME} — cluster ${CLUSTER} — region ${REGION} | jq .failures[]`

#Get latest revision
REVISION=`aws ecs describe-task-definition — task-definition ${NAME} — region ${REGION} | jq .taskDefinition.revision`

#Create or update service
#Create or update service
if [ "$SERVICES" == "" ]; then
  echo "entered existing service"
  DESIRED_COUNT=`aws ecs describe-services --services ${SERVICE_NAME} --cluster ${CLUSTER} --region ${REGION} | jq .services[].desiredCount`
  if [ ${DESIRED_COUNT} = "0" ]; then
    DESIRED_COUNT="3"
  fi
  aws ecs update-service --cluster ${CLUSTER} --region ${REGION} --service ${SERVICE_NAME} --task-definition ${FAMILY}:${REVISION} --desired-count ${DESIRED_COUNT}
else
  echo "entered new service"
  aws ecs create-service --service-name ${SERVICE_NAME} --desired-count 1 --task-definition ${FAMILY} --cluster ${CLUSTER} --region ${REGION}
fi
