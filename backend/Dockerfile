# Use lightweight OpenJDK image
FROM openjdk:17-jdk-slim

# Set environment
ENV JAVA_OPTS=""

# Create app directory
WORKDIR /app

# Copy JAR and resources
COPY target/jokehub-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8080

# Run application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]

# End of Dockerfile