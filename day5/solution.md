## Topic: DockerHub/Registry

Topics to be Covered
------------------------
* What is DockerHub and application of docker hub.
* How to use DockerHub to push and pull images..

Assignment
-------------------
* Signup on dockerhub.

      Sol: Signup on docker hub.

* Login on dockerhub and create a repository by providing repo name "mytestrepo" and a little description about the same.
     
     ![createrepository](https://github.com/kamal24111991/dockerassignment/blob/master/day5/media/createrepository.png)

* Search for "centos" image on docker using commandline.
      ![dockerpullcentos](https://github.com/kamal24111991/dockerassignment/blob/master/day5/media/dockerpullcentos.png)

* Limit out search result to 10 entries only.
       ![searchlimit10](https://github.com/kamal24111991/dockerassignment/blob/master/day5/media/searchlimit10.png)

* Apply a filter on search result to show entries for images having 3 stars.
         ![3star](https://github.com/kamal24111991/dockerassignment/blob/master/day5/media/3star.png)
         
* Format the search result to get output containing only name,description and is_official values.
        ![formattable](https://github.com/kamal24111991/dockerassignment/blob/master/day5/media/formattable.png)

* Pull an image named "centos" from dockerhub.
         ![dockerpullcentos](https://github.com/kamal24111991/dockerassignment/blob/master/day5/media/dockerpullcentos.png)

* Tag "centos" image with name "mycentos" in your repository with version 1.1
          ![tagmycentos](https://github.com/kamal24111991/dockerassignment/blob/master/day5/media/tagmycentos.png)

* Push that image to your repo "mytestrepo" on your dockerhub.
           ![dockerpush](https://github.com/kamal24111991/dockerassignment/blob/master/day5/media/dockerpush.png)
           ![pushedimagestomytestrepo](https://github.com/kamal24111991/dockerassignment/blob/master/day5/media/pushedimagestomytestrepo.png)
* Do commandline logout on dockerhub.

Reference
-----------------
[DockerHub/Registry](https://docs.docker.com/develop/develop-images/image_management/)
