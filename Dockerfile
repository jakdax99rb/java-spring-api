FROM eclipse-temurin:17-jdk-alpine
LABEL authors="jakdax99rb"
COPY target/java-spring-api-0.0.1-SNAPSHOT.jar application.jar
ENTRYPOINT ["java","-jar", "/application.jar"]