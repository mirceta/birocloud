#!/bin/bash
cd $playground/rso/birocloud/support/docker_build_area

cd users
cp $userstargetbirocloud/*.jar .
docker build -t users-api .
docker run --name service-users -p 8080:8080 users-api