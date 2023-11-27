FROM openjdk:17-oracle
CMD ["./mvnw", "clean", "package"]
COPY ./target/superapp-spring-benchmark-0.0.1-SNAPSHOT.jar app.jar
COPY ./start.sh /start.sh
RUN chmod +x /start.sh
ENTRYPOINT ["/start.sh"]