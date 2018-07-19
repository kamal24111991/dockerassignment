Assignment 3 Docker

Assignment 1
Docker Port:
1. Pull nginx image from dockerhub.
```
#docker pull nginx
![nginximagepull](https://github.com/kamal24111991/dockerassignment/blob/master/day3/media1/nginximagepull.png)

2. Run a container from nginx image and map container port 80 to system port 80.
```
#docker run -itdp 80:80 nginx
![Runnginxport80](https://github.com/kamal24111991/dockerassignment/blob/master/day3/media1/Runnginxport80.png)``

3. Display all mapped ports on nginx image.
```
#docker container port f17fd0a4ec4e
```
![mappedport](https://github.com/kamal24111991/dockerassignment/blob/master/day3/media1/mappedport.png)

4. Run a docker container named "containexpose" from nginx image and expose port 80 of container to outer world without mapping it to any of system port.
```
#docker run -itd --network host --name nginx1 nginx

#netstat -tulpn | grep :80

```
Docker Volume:

1. Create docker volume named "dbvol"
```
#docker volume create dbvol
![createddbvol](https://github.com/kamal24111991/dockerassignment/blob/master/day3/media2/createddbvol.png)
```
2. Run docker container from wordpress image and mount "dbvol" to /var/lib/mysql
```
#docker run -it --name wordpress -v dbvol:/var/lib/mysql wordpress bash
```

3. Display all docker volumes.
```
#docker volume ls
```
![dockervolumestatus](https://github.com/kamal24111991/dockerassignment/blob/master/day3/media2/dockervolumestatus.png)

4. Create another docker volume named "testvol"

#docker volume create testvol

![addtestvol](https://github.com/kamal24111991/dockerassignment/blob/master/day3/media2/addtestvol.png)

5. Remove docker volume "testvol"
```
#docker volume rm testvol
```

Docker Linking:

1. Run a container in detached mode with name "db" from image "training/postgres"
```
#docker run -itd –name db training/postgres
```
2. Run another container in detached mode with name "web" from image "training/webapp", link container "db" with alias "mydb" to this container and finally pass an inline command "python app.py" while running container.
```
#docker run -itd –name web –link db:mydb  training/webapp python app.py
```
![dbdocker](https://github.com/kamal24111991/dockerassignment/blob/master/day3/media3/dbdocker.png)

3. Take a bash terminal in "web" container.
```
#docker exec -it web bash
```
![linkwebtomyd](https://github.com/kamal24111991/dockerassignment/blob/master/day3/media3/linkwebtomyd.png)

4. Test container linking by doing a ping to "mydb"

ping mydb
![pingmydb](https://github.com/kamal24111991/dockerassignment/blob/master/day3/media3/pingmydb.png)
