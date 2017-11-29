#!/bin/bash

# Run users database in docker:

docker run -d --name postgres-users -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=users -p 5434:5432 postgres:latest

# Run account options database in docker:

docker run -d --name postgres-accountoptions -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=accountoptions -p 5435:5432 postgres:latest