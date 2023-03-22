#!/bin/sh

docker build -t my-ubuntu-image .
docker run my-ubuntu-image ls /archive