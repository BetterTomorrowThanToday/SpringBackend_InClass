# Use an OpenJDK image as the base image
FROM openjdk:17-jdk-slim as builder

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle wrapper and the build.gradle files
COPY gradlew build.gradle settings.gradle ./
COPY gradle gradle

# Download dependencies (Gradle build)
RUN ./gradlew build --no-daemon

# Copy the whole source code
COPY . .

# Build the Spring Boot application using Gradle
RUN ./gradlew bootJar --no-daemon

# Use a smaller base image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose the port your app is running on
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]