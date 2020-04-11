FROM openjdk:8-jre-alpine

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY target/*.jar app.jar

ENTRYPOINT ["/usr/bin/java", "-jar", "app.jar"]