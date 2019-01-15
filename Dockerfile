# docker build -t spring-boot-starter .
# docker run -p 8080:8080 -it spring-boot-starter

FROM maven:3.6.0-jdk-8

# ADD target/spring-boot-starter-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# CMD ["java", "-jar", "app.jar"]

