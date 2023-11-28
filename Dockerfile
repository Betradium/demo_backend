FROM openjdk:17-jdk-alpine
COPY build/libs/*.jar /dockerapp/dockerapp.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "/dockerapp/dockerapp.jar"]