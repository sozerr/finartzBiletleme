FROM openjdk:8-jre-alpine

MAINTAINER SEYDA OZER <seydaozer5@gmail.com>

WORKDIR /opt

COPY maven/${project.build.finalName}.${project.packaging} app.jar

ENTRYPOINT exec java ${JAVA_OPTS} -jar app.jar

