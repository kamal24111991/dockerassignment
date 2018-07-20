## Topic: Docker DOCKERFILE

Topics to be Covered
------------------------
* What is DockerFile.
* How DockerFile is easing the things that we were doing using Docker CLI.

Assignment 1
-------------------
1. Create a file named index.js with below content.

index.js
----------------
var os = require("os");
var hostname = os.hostname();
console.log("hello from " + hostname);

Created Index.js file in local directory of local machine and created Dockerfile.
https://github.com/kamal24111991/dockerassignment/blob/master/day4/assignment1/index.js


2. Create a file named Dockerfile and write code as per the steps mentioned.

* Use alpine image.
* Add Author/Maintainer name in DockerFile
* run commands -> apk update & apk add nodejs
* copy current directory to /app
* change your working directory to /app
* specify the default command to be run upon container creation as mentioned below.
	node index.js

        Solution: Docker file link 
	      https://github.com/kamal24111991/dockerassignment/blob/master/day4/assignment1/Dockerfile
	
	
3. Build image from Dockerfile.

        Solution: docker build -t nodejs .
     ![dockerimagebuild](https://github.com/kamal24111991/dockerassignment/blob/master/day4/media/dockerimagebuild.png)

4. Tag image with name "hello:v0.1"
        Solution: docker image tag nodejs hello:v0.1
	![TAG](https://github.com/kamal24111991/dockerassignment/blob/master/day4/media/TAG.png)
	  
Assignment 2
-----------------------
1. Create a DockerFile.

2. Use Ubuntu latest image.
3. Add your name as a Manintainer.
4. Update local packages using command (apt-get update).
5. Install nodejs package.
6. Install npm package.
7. Create a symlink using command (ln -s /usr/bin/nodejs /usr/bin/node).
8. Trigger a command (npm install -g http-server)
9. Add any test index.html file from local at /usr/apps/hello-docker/index.html on container.
10. change your working directory to /usr/apps/hello-docker/.
11. Run a command (http-server -s) on every container initialization.

         Solution: Docker file link:
	 https://github.com/kamal24111991/dockerassignment/blob/master/day4/assignment2/Dockerfile
	           
		    Index.html link:

       https://github.com/kamal24111991/dockerassignment/blob/master/day4/assignment2/index.html
		  

12. Build your dockerfile and tag it with "yourname:docker-web"

![dockerbuildkamal](https://github.com/kamal24111991/dockerassignment/blob/master/day4/media2/dockerbuildkamal.png)

13. Run a docker container from the image that you have just created and map container 8080 port to host 8080 port.(8080:8080)

![runcontainer](https://github.com/kamal24111991/dockerassignment/blob/master/day4/media2/runcontainer.png)

14. Try accessing your webpage using "http://<virtualmachine_ipaddress>:8080/index.html" URL.

Website up and running
![websiterunning](https://github.com/kamal24111991/dockerassignment/blob/master/day4/media2/websiterunning.png)

15. Delete docker container and image from local.

#docker stop kamal:dockerweb
#docker rm kamal:dockerweb
#docker rmi kamal:dockerweb


Reference
-----------------
[Docker DockerFile](https://docs.docker.com/engine/reference/builder/)
