FROM navikt/java:14

ARG JAR_PATH

ADD $JAR_PATH /app/app.jar