FROM openjdk:17-jdk-alpine

VOLUME /tmp/

COPY build/libs/*.jar ConfigServer.jar

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "ConfigServer.jar"]
