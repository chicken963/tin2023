#!/bin/sh

docker build -t my-multistage-image .
docker run my-multistage-image ls /archive