## Topic: Docker Installation on Centos 7

Topics to be Covered
-------------------------
* Installing Docker using yum or apt.
* Installing Docker Automatically using official shell script.

What You Will Learn
----------------------------
How easy it is to install and configure Docker for yourself.

The Assignment
--------------------------
1. Use official shell script to install and configure Docker on your control machine.
Solution:  Script to install docker 'curl -fsSL https://get.docker.com/ | sh'
![dockerscript](https://github.com/kamal24111991/dockerassignment/blob/master/day1/media/dockerscript.png)

2. Start Docker service and check status of the same.
Solution: sudo systemctl start docker
          sudo systemctl status docker
![servicestatus](https://github.com/kamal24111991/dockerassignment/blob/master/day1/media/servicestatus.png)

3. Enable Docker service to start at every machine reboot.
Solution: Sudo systemctl enable docker

4. Display Docker version.
Solution: docker --version
![dockerversion](https://github.com/kamal24111991/dockerassignment/blob/master/day1/media/dockerversion.png)

5. Configure non root user to run docker commands without sudo.
Solution: usermod -aG docker vagrant
![dockernonrootuser](https://github.com/kamal24111991/dockerassignment/blob/master/day1/media/dockernonrootuser.png)

6. Type docker on commandline and read output i.e containing related commands.
Solution:
![dockercommand](https://github.com/kamal24111991/dockerassignment/blob/master/day1/media/dockercommand.png)

7. Display System information using Docker.
Solution: docker info
![dockersysteminfo](https://github.com/kamal24111991/dockerassignment/blob/master/day1/media/dockersysteminfo.png)

8. Check whether you can access/download images from DockerHub or not.
Solution: docker pull alpine
![pullimage](https://github.com/kamal24111991/dockerassignment/blob/master/day1/media/pullimage.png)

Reference
----------------
[Docker Installation](https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-centos-7)
