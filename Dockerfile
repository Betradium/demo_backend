FROM openjdk:17-jdk-alpine
ADD build/libs/demo-0.0.1-SNAPSHOT.jar /dockerapp/dockerapp.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "/dockerapp/dockerapp.jar"]