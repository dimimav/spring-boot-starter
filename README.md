# Spring Boot starter project

Tools included:
* Spring Boot
* Spring MVC
* Spring Data JPA
* Spring Boot DevTools
* MySQL/Postgres Connector
* Thymeleaf

## Run as packaged application

`mvn package`

`java -jar target/spring-boot-starter-0.0.1-SNAPSHOT.jar`

## Run using the Maven Spring Boot plugin (JVM hot swapping)
`mvn spring-boot:run`

## Run in docker container
 Update Spring datasource in application.properties to:
  
`spring.datasource.url = jdbc:mysql://spring-boot-starter-database:3306/spring_boot_starter?useSSL=false`

Start docker containers:

`docker-compose up`
