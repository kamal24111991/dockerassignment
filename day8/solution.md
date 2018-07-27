Docker Day 8 Assignment

Assignment

Create an ECS cluster
----------------------

Setup 2 instances cluster 

```
created a clusterer named "cluster" with 2 t2.small instances 
```
![day8_1](https://github.com/kamal24111991/dockerassignment/blob/master/day8/media/day8_1.png)

Instances

![day8_3](https://github.com/kamal24111991/dockerassignment/blob/master/day8/media/day8_3.png)

Create ECR repository for nginx image 
![day8_4](https://github.com/kamal24111991/dockerassignment/blob/master/day8/media/day8_4.png)

```
created nginx repo in ECR
```
![day8_2](https://github.com/kamal24111991/dockerassignment/blob/master/day8/media/day8_2.png)




nginx-webserver services onto ECS cluster

step1: Create a task definition 
```
created a task definition named nginx
```
![day8_5_taskdefinition](https://github.com/kamal24111991/dockerassignment/blob/master/day8/media/day8_5_taskdefinition.png)


step2: Create a service using task definition 

```
created a service named nginx .
```
![day8_7services](https://github.com/kamal24111991/dockerassignment/blob/master/day8/media/day8_7services.png)


Step3: Start nginx service in the cluster 

Scale nginx service to 2 containers 

![day8_6cluster](https://github.com/kamal24111991/dockerassignment/blob/master/day8/media/day8_6cluster.png




Attach ECS services to application load balancer.

Step1: Create a load balancer 
------------------------

![day_8_lb2](https://github.com/kamal24111991/dockerassignment/blob/master/day8/media/day_8_lb2.png)

Step2: Register ECS instance nodes 
----------------------------
```
Created a target group for ECS cluster's instances 
```
![media/day_8_lb3](https://github.com/kamal24111991/dockerassignment/blob/master/day8/media/day_8_lb3.png)

Step3: Access Nginx service 
----------------------------
```
Accessing nginx service via ALB
```
![day_8_LB](https://github.com/kamal24111991/dockerassignment/blob/master/day8/media/day_8_LB.png)
