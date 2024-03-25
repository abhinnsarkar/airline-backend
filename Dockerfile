# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-rc-jdk-bullseye as base

# Update the package list and install Gradle
RUN apt-get update && \
    apt-get install -y gradle && \
    rm -rf /var/lib/apt/lists/*

# Set the working directory in the container
WORKDIR /app

# Copy the project files
COPY build.gradle settings.gradle gradlew /app/
COPY gradle /app/gradle
RUN ./gradlew --no-daemon --version

# Copy the source code
COPY src /app/src

# Build the application
RUN ./gradlew --no-daemon build

# Create a new stage for deployment
FROM base as deploy

WORKDIR /app

# Copy the built application from the 'base' stage
COPY --from=base /app/build/libs/*.jar /app/app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Copy the entrypoint script into the container
COPY entrypoint.sh /entrypoint.sh

# Make the entrypoint script executable
RUN chmod +x /entrypoint.sh

# Set the entrypoint
ENTRYPOINT ["/entrypoint.sh"]
