#! /bin/sh

cd ./customer-service
mvn clean package -DskipTests
docker build -t customer-service:latest .
cd ..

# cd ./employee-service
# mvn clean package
# docker build -t employee-service:latest .
# cd ..

# cd ./shipper-service
# mvn clean package
# docker build -t shipper-service:latest .
# cd ..


