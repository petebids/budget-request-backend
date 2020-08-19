FROM openjdk:11
VOLUME /tmp
COPY /target/budget-request-backend-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-jar", "app.jar"]