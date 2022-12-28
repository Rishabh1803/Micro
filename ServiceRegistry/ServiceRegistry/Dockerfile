# Determine the java version
FROM openjdk:17-jdk-alpine

VOLUME /tmp

# Copies the jars. First argument is for hostmachine and second for container
COPY build/libs/*.jar ServiceRegistry.jar

# Exposes the port that will be used for running
EXPOSE 8761

# This determines which java jar file needs to be run
ENTRYPOINT ["java", "-jar", "ServiceRegistry.jar"]


# Build using the following command
# docker build -t <name>:<version> <location>
# docker build -t service-registry:1.0 .
# name should be in lowercase only

# Run the image using: (-d is for detached mode)
# docker run -p <port>:<port> -d <image-name>

# docker ps   --> for all the containers running
# docker logs <id>  --> For logs