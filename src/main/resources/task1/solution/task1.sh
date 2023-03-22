#!/bin/sh

docker run --rm nginx:mainline du -h /docker-entrypoint.sh

# также подойдёт docker exec nginx:mainline ls -lh /docker-entrypoint.sh