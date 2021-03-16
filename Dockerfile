FROM openjdk:8-jdk-alpine
EXPOSE 9092
COPY target/*.jar user-service.jar
ENTRYPOINT ["java","-jar","/user-service.jar"]
