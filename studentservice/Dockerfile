FROM openjdk:17
EXPOSE 8081
ADD target/studentservice-0.0.1-SNAPSHOT.jar student.jar
ENTRYPOINT ["java", "-jar", "student.jar"]