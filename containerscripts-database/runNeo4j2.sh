#!/bin/sh

docker run --name neoWorking -p 7474:7474 -p 7687:7687 -d -e NEO4J_AUTH=none -v ~/Documents/UandR/containerscripts-database/data/n4j:/data -v ~/Documents/UandR/containerscripts-database/logs/n4j/:/logs neo4j
docker ps
