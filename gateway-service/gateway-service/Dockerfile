FROM openjdk:17-jdk-slim
EXPOSE 5050
COPY target/gateway-service-0.0.1.jar gateway-service-0.0.1.jar
ENTRYPOINT ["java","-jar","/gateway-service-0.0.1.jar"]