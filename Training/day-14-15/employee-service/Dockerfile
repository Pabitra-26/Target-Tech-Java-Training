FROM adoptopenjdk/openjdk11:alpine-slim

WORKDIR /Z0083BX/employeeapp/workspace

COPY ./target/employee-service-0.0.1-SNAPSHOT.jar ./employeeapp.jar


EXPOSE 9090

ENTRYPOINT java -jar ./employeeapp.jar