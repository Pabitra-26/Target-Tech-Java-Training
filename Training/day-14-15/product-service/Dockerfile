FROM adoptopenjdk/openjdk11:alpine-slim

WORKDIR /Z0083BX/app/workspace

COPY ./target/product-service-0.0.1-SNAPSHOT.jar ./app.jar


EXPOSE 9090

ENTRYPOINT java -jar ./app.jar