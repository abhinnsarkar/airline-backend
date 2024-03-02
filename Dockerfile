## Use an official OpenJDK runtime as a parent image
#FROM openjdk:21-rc-jdk-bullseye as base
#
## Update the package list and install Maven
#RUN apt-get update && \
#    apt-get install -y maven && \
#    rm -rf /var/lib/apt/lists/*
#
## Set the working directory in the container
#WORKDIR /app
#
## Copy the project files
#COPY pom.xml .
#
#RUN mvn dependency:resolve
#
#
#FROM base as deploy
#
#WORKDIR /app
## Package the application
#COPY . .
#RUN mvn package -DskipTests
#
## Make port 8080 available to the world outside this container
#EXPOSE 8080
#
## Run the JAR file
#ENTRYPOINT ["./entrypoint.sh"]

# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-rc-jdk-bullseye as base

# Update the package list and install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Set the working directory in the container
WORKDIR /app

# Copy the project files
COPY pom.xml .

RUN mvn dependency:resolve

# Create a new stage for deployment
FROM base as deploy

WORKDIR /app
# Package the application
COPY . .
RUN mvn package -DskipTests

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Copy the entrypoint script into the container
COPY entrypoint.sh /entrypoint.sh

# Make the entrypoint script executable
RUN chmod +x /entrypoint.sh

ARG DB_URL_ARG="DB_URL_ARG missing"
ENV DB_URL=${DB_URL_ARG}

ARG DB_USER_ARG="DB_USER_ARG missing"
ENV DB_USER=${DB_USER_ARG}

ARG DB_PASS_ARG="DB_PASS_ARG missing"
ENV DB_PASS=${DB_PASS_ARG}

# Set the entrypoint
ENTRYPOINT ["/entrypoint.sh"]
