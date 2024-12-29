FROM openjdk:22-jdk-slim

WORKDIR /app

COPY target/Testing-0.0.1-SNAPSHOT.jar /app/testcicd.jar

EXPOSE 8081

# Run the JAR file
ENTRYPOINT ["java", "-jar", "testcicd.jar"]