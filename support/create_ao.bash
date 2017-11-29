#!/bin/bash

cd $playground/rso/birocloud/support/docker_build_area

# Run account options service in docker:

cd accountoptions
cp $accountoptionstargetbirocloud/*.jar .
docker build -t ao-api .
docker run -d --name service-ao -p 8081:8080 ao-api