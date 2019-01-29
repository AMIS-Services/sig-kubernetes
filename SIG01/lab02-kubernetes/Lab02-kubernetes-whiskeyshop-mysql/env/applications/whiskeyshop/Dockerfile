# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="amis"

# Application runs on port 8080
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=target/whiskeyshop-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} whiskeyshop.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","/whiskeyshop.jar"]
