## Topic: Docker-Compose day1

Topics to be Covered
------------------------
* What is Docker-Compose file.
* Why Docker-Compose.
* How Docker-compose ease the image and container creation.

Assignment
-------------------
* Install docker-compose on your machine, if not already installed.

Solution :   Install docker compose through script, which is available on docker user guide
------------
sudo curl -L https://github.com/docker/compose/releases/download/1.22.0/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose

sudo chmod +x /usr/local/bin/docker-compose

* Check docker-compose version.

Solution:     docker --version  ( Check docker version )
-----------

* Create a directory named nginx in your root.

Solution:    mkdir /nginx
---------- 

* Switch to that directory and create a file named docker-compose.yaml

Solution:   cd /nginx  
          vi docker-compose.yml

             
* Use docker-compose version 2 to create docker-compose.yaml file.
* Create a service named "databases".
* Use image named "mysql"
* Map container 3306 port to host machine 3306 port.
* Add environment variables named "MYSQL_ROOT_PASSWORD", "MYSQL_DATABASE", "MYSQL_USER" and "MYSQL_PASSWORD" along with corresponding values for all.

* Add another service named "web"
* Use image "nginx"
* Save docker-compose.yaml file and do docker-compose up.
Solution:
----------
```
version: '3'
services:
  databases:
    image: mysql
    ports:
      - "3307:3306"
    env_file:
      - evs.env
  web:
    image: nginx
    ports:
      - "80:80" 
    depends_on:
      - databases
```
    
    ![day6_1](https://github.com/kamal24111991/dockerassignment/blob/master/day6/media/day6_1.png)
    ![day6_2](https://github.com/kamal24111991/dockerassignment/blob/master/day6/media/day6_2.png)

* Verify nginx service is up and is accessible on machine.
 Solution:
           Please refer screenshot Nginx is up and running.
       ![day6_3](https://github.com/kamal24111991/dockerassignment/blob/master/day6/media/day6_3.png)
           
* Stop and remove your docker container using docker-compose.
            ![day6_6](https://github.com/kamal24111991/dockerassignment/blob/master/day6/media/day6_6.png)


Reference
-----------------
[Docker-Compose](https://docs.docker.com/compose/overview/)
