FROM ubuntu:22.04 AS builder

WORKDIR /archive

RUN apt-get update && apt-get install -y wget unzip

RUN wget https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-zip-file.zip && \
    unzip sample-zip-file.zip && \
    rm sample-zip-file.zip

FROM scratch

COPY --from=builder /archive/sample.txt /archive/sample.txt

CMD ["/archive/sample.txt"]