# Use official OpenJDK 17 image as base
FROM openjdk:17

# Copy your Java app JAR file into the container
COPY target/30-SpringBoot_RestAPI-0.0.1-SNAPSHOT.jar  /usr/app/springboot-rest-api.jar

# Set the working directory
WORKDIR  /usr/app/

# Run the JAR file
ENTRYPOINT ["java", "-jar", "springboot-rest-api.jar"]
EXPOSE 9090
