# Mountain Bike Race Results Tracker Application
This is a Spring Boot application designed to track and manage mountain bike race results. 
It stores information on riders, races, and race results, and provides several reports such 
as the top 3 fastest riders, riders who did not finish, and weather conditions during the race 
using a public API.

## Requirements
    Java 17
    Maven build tool
    PostgreSQL

### Getting Started
To get started with the Mountain Bike Race Results Tracker application, follow the steps below:
Clone the repository: git clone https://github.com/ehis0075/Mountain-Bike-Race-Results-Tracker-App.git

### Navigate to the project directory:
cd sports

### Build the project using Maven:
mvn clean package

### Run the Application Locally:
java -jar target/race-result-service.jar

### The API service will be accessible at http://localhost:8085/api/v1


# Dockerize the Application
### This Dockerfile uses a multi-stage build approach:

    Build Stage:
        The maven:3-openjdk-17-slim image is used to build the Java application. 
        The source code and pom.xml are copied, and the application is compiled into a JAR file using Maven.

    Package Stage:
        The amazoncorretto:17 image is used to run the application. The JAR file from the build stage is 
        copied into the container, and the application is started with the java command.

### You can build a Docker image for the application using the following command:
docker build -t race-result-service-docker:latest .

### Run the Docker container using the following command:
docker run -p 8085:8085 race-result-service-docker:latest

### The API service will be available at http://localhost:8085/api/v1


# Continuous Integration/Continuous Deployment (CI/CD)

### The project includes a Jenkinsfile to automate the build, deployment, and running of a Docker for the application. The pipeline has three stages: build, remove-old, and run.
### This Jenkins pipeline automates the build, deployment, and running of the Docker container:

    Build Stage:
        Builds the Docker image for the race-result-service using the docker build command.

    Remove-Old Stage:
        Stops and removes any previously running container named race-result-service using the docker rm -f command.

    Run Stage:
        Starts a new Docker container from the built image, mapping port 8085 and setting the timezone to Africa/Lagos.


# API Endpoints
### 1. Top 3 Fastest Riders Per Race : This api displays the top 3 riders based on their race times for a given race.
### Endpoint: /api/v1/race-results/top3/riders/{raceId}
### Method: GET
### This API requires raceId as a path variable.

### 2. Top 3 Race Result Per Race : This api displays the top 3 race result based on their race times for a given race.
### Endpoint: /api/v1/race-results/top3/{raceId}
### Method: GET
### This API requires raceId as a path variable.

### 3. Riders Who Did Not Finish the Race : This report displays all riders who started the race but did not finish.
### Endpoint: /api/v1/race-results/did-not-finish/{raceId}
### Method: GET
### This API requires raceId as a path variable.

### 4. Riders Who Did Not Participate : This report lists all riders who did not participate in a given race.
### Endpoint: /api/v1/race-results/not-participated/{raceId}
### Method: GET
### This API requires raceId as a path variable.

### 5. Weather Conditions for the Race Location : This endpoint fetches the weather conditions at the race location using a public weather API.
### Endpoint: /api/v1/weather/{raceLocation}
### Method: GET
### This API requires raceLocation as a path variable.


# Unit Testing

### The project includes unit tests to validate the functionality of the service.

### To run the tests:

mvn test