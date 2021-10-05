FROM adoptopenjdk/openjdk11:alpine-slim

WORKDIR /Z0083BX/shipperapp/workspace

COPY ./target/shipper-service-0.0.1-SNAPSHOT.jar ./shipperapp.jar


EXPOSE 9090

ENTRYPOINT java -jar ./shipperapp.jar