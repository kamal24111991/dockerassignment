## Topic: Docker CLI

Topics to be Covered
-----------------------
How to ease your work using Docker CLI.
Docker run.
Docker (Base command).
Docker container.

Assignment 1
-----------------------
1. Run a docker container from "hello-world" image.

Sol: HelloWorld
![HelloWorld](https://github.com/kamal24111991/dockerassignment/blob/master/day2/media1/HelloWorld.png)

2. Pull "alpine" image from docker registry and see if image is available in your local image list.

Sol: docker pull alpine
![dockeralpineimages](https://github.com/kamal24111991/dockerassignment/blob/master/day2/media1/dockeralpineimages.png)

3. Pull some specific version of docker "alpine" image from docker registry.

Sol: docker pull alpine:3.7
![alpinespecificversion](https://github.com/kamal24111991/dockerassignment/blob/master/day2/media1/alpinespecificversion.png)

4. Run a docker container from local image "alpine" and run an inline command "ls -l" while running container.

Sol: docker run -it alpine ls -l

![dockerinline](https://github.com/kamal24111991/dockerassignment/blob/master/day2/media1/dockerinline.png)

5. Try to take login to container created using "alpine" image.

Sol: docker run -it alpine /bin/ash
![loginofalpine%20container](https://github.com/kamal24111991/dockerassignment/blob/master/day2/media1/loginofalpine%20container.png)

6. Detach yourself from the container without making it exit/container kill.

Sol: ctrl +p +q


7. Check running containers and see if you can find out the stopped containers.

Sol: docker ps

8. Stop running container.

Sol: docker stop firstdocker

![stopdockercontainer](https://github.com/kamal24111991/dockerassignment/blob/master/day2/media1/stopdockercontainer.png)

9. Start container that was stopped earlier.

Sol: docker start <containerid>
![dockerstart](https://github.com/kamal24111991/dockerassignment/blob/master/day2/media1/dockerstart.png)

10. Try to remove "alpine" image from your local system.

![removeimages](https://github.com/kamal24111991/dockerassignment/blob/master/day2/media1/removeimages.png)

Assignment 2
---------------------
1. Again pull "alpine" image from docker registry.
2. Take interactive login to bash while running docker container from "alpine" image.
3. Run command inside container: 
	echo "hello world" > hello.txt
	ls
4. Take exit from same container without killing the container.
5. Run another container using below command and check if you can find hello.txt within this container. You should find container isolations from step 3-5.
	docker container run alpine ls
6. Stop a container using Container ID.
7. Start same container using ID and exec a command "echo 'hello world!'" in docker container without instantiating a new container.
8. Inspect already downloaded "alpine" docker image using docker inspect command.
9. Tag your local "alpine" image with name "myimage" along with version 1.0

Reference
--------------
[Docker CLI](https://docs.docker.com/engine/reference/run/)
