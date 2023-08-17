#!/bin/sh

docker run --name maWorking2 -e MYSQL_ROOT_PASSWORD=mypass -e MYSQL_DATABASE=mark -e MYSQL_USER=mark -e MYSQL_PASSWORD=mark -p 3306:3306 -d -v ~/Documents/UandR/containerscripts-database/data/mysql:/var/lib/mysql mariadb:10.3

docker ps




