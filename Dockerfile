FROM openjdk:17-jdk-alpine
COPY build/libs/*.jar /demo/dockerapp.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "/demo/dockerapp.jar"]