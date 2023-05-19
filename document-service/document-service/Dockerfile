FROM openjdk:17-jdk-slim
EXPOSE 7080
COPY target/document-service-0.0.1.jar document-service-0.0.1.jar
ENTRYPOINT ["java","-jar","/document-service-0.0.1.jar"]