#!/bin/bash
# stop everything
docker stop service-ao
docker stop service-users
docker stop postgres-accountoptions
docker stop postgres-users
docker rm service-ao
docker rm service-users
docker rm postgres-accountoptions
docker rm postgres-users

docker rmi ao-api
docker rmi users-api