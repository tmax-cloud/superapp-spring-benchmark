FROM adoptopenjdk/openjdk11
CMD ["./mvnw", "clean", "package"]
COPY ./target/superapp-spring-benchmark-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]