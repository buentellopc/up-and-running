#!/bin/sh

docker run --name maRedis -p 6379:6379 -d -v ~/Documents/UandR/containerscripts-database/data/redis:/data hecklerm/redis

docker ps
