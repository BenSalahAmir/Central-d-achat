FROM openjdk:8-jdk-alpine
COPY target/*.jar app.jar
WORKDIR /app
EXPOSE 9090
CMD ["java","-jar","/app.jar"]
