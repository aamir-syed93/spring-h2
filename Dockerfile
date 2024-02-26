FROM openjdk:17
EXPOSE 8080
ADD target/spring-aws-app.jar spring-aws-app.jar
ENTRYPOINT ["java","-jar","spring-aws-app.jar"]