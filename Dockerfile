## BUILD Stage ##
FROM gradle:jdk21-jammy AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
# for all env-variables that we will use in the future:
ARG DB_PASSWORD
ARG DB_URL
ARG DB_USER
RUN gradle build --no-daemon -x test

## Package Stage ##
FROM eclipse-temurin:21-jdk-jammy
COPY --from=build /home/gradle/src/build/libs/Webtech-projekt-0.0.1-SNAPSHOT.jar app.jar

# Set environment variables for PostgreSQL (optional)
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://dpg-cu2jkrbv2p9s738v4il0-a.frankfurt-postgres.render.com:5432/books_db_wi0k
ENV SPRING_DATASOURCE_USERNAME=books_db_wi0k_user
ENV SPRING_DATASOURCE_PASSWORD=13APyYj82JtInnXtqejooG4jBn5pu1rt
ENV SPRING_DATASOURCE_DRIVER_CLASS_NAME=org.postgresql.Driver


# Start the application
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
