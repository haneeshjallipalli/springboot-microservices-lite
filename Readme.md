
```
docker run -d --name school-service -p 8080:8080 school-service-image
docker run -d --name student-service -p 8081:8081 student-service-image
```

By default, containers are on the same bridge network. If you create a custom network (recommended), add both containers to it:
```
docker network create my-network
docker network connect my-network school-service
docker network connect my-network student-service
```