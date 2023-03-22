#!/bin/sh

docker build -t nginx-hello-world .
docker run -p 8080:80 nginx-hello-world