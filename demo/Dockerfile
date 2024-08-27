FROM amazoncorretto:21

WORKDIR /app
EXPOSE 8080
COPY target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]