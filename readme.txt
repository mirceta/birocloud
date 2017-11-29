#!/bin/bash

# Run users database in docker:

docker run -d --name postgres-users -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=users -p 5434:5432 postgres:latest

# Run account options database in docker:

docker run -d --name postgres-accountoptions -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=accountoptions -p 5435:5432 postgres:latest



cd $playground/rso/docker_build_area

# Run account options service in docker:

cd accountoptions
cp $accountoptionstargetbirocloud/*.jar .
docker build -t users-api .
docker run -d --name service-users -p 8080:8080 users-api

# Run users service in docker:

cd ../users
cp $userstargetbirocloud/*.jar .
docker build -t ao-api .
docker run -d --name service-ao -p 8081:8080 ao-api

cd ../../birocloud



# stop everything
docker stop service-ao
docker stop service-users
docker stop postgres-accountoptions
docker stop postgres-users
docker rm service-ao
docker rm service-users
docker rm postgres-accountoptions
docker rm postgres-users