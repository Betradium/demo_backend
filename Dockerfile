FROM openjdk:17-jdk-alpine
ADD build/libs/*plain.jar /dockerapp/dockerapp.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "/dockerapp/dockerapp.jar"]