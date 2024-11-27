# Use Maven image with JDK
FROM maven:3.8.8-openjdk-17 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy only the pom.xml and dependency files initially
COPY pom.xml /app/

# Download Maven dependencies
RUN mvn dependency:go-offline -B

# Copy the entire project
COPY . /app

# Build the project
RUN mvn clean package -DskipTests

# Final runtime image
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
