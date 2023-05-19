FROM openjdk:17-jdk-slim
EXPOSE 7070
COPY target/message-service-0.0.1.jar message-service-0.0.1.jar
ENTRYPOINT ["java","-jar","/message-service-0.0.1.jar"]