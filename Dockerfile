FROM openjdk:17
WORKDIR /app
COPY target/spring-0.0.1-SNAPSHOT.jar /app/spring-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring-0.0.1-SNAPSHOT.jar"]
