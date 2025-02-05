FROM openjdk:21-jdk

WORKDIR /app

COPY target/API-notification-0.0.1-SNAPSHOT.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]

