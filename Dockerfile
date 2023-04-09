FROM amazoncorretto:19-alpine
WORKDIR /app
COPY target .
EXPOSE 8080
CMD ["java", "-jar", "hogwarts-houses-0.0.1-SNAPSHOT.jar"]