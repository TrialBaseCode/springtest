# Stage 1: Build the application
FROM maven:3-ibm-semeru-17-focal AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/spring-0.0.1-SNAPSHOT.jar /app/spring-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring-0.0.1-SNAPSHOT.jar"]
