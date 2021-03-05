FROM openjdk:8
EXPOSE 9092
ADD target/techhmr-userservice.jar techhmr-userservice.jar
ENTRYPOINT ["java","-jar","/techhmr-userservice.jar"]