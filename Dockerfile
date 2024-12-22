FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/creamy-bites-server-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=${SPRING_PROFILES_ACTIVE}"]

