FROM gradle:8-jdk17-alpine as build
WORKDIR /app
COPY . .
RUN gradle build

FROM openjdk:17-jdk-slim-buster
ARG VERSION=0.0.9-SNAPSHOT

WORKDIR /app
COPY --from=build /app/build/libs/orders-${VERSION}.jar app.jar

EXPOSE 8095
CMD ["java", "-jar", "app.jar"]


