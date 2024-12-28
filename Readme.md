```
cd springboot-microservices-lite
cd schoolservice
mvn clean install
cd ..
cd studentservice
mvn clean install
cd ..

docker build -t school-service-image ./schoolservice
docker build -t student-service-image ./studentservice
docker run -d --name school-service -p 8080:8080 school-service-image
docker run -d --name student-service -p 8081:8081 student-service-image

docker network create my-network
docker network connect my-network school-service
docker network connect my-network student-service
```
