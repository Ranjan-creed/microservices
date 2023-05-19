FROM openjdk:17-jdk-slim
EXPOSE 7080
COPY target/user-service-0.0.1.jar user-service-0.0.1.jar
ENTRYPOINT ["java","-jar","/user-service-0.0.1.jar"]