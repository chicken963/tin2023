FROM ubuntu:22.04

# Установка утилит для загрузки и архивации файлов
RUN apt-get update && apt-get install -y wget unzip

# Создание каталога для загружаемого архива
RUN mkdir /archive

# Загрузка архива в каталог /archive и распаковка его содержимого
RUN wget -q -O /tmp/sample-zip-file.zip https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-zip-file.zip \
  && unzip -qq /tmp/sample-zip-file.zip -d /archive \
  && rm /tmp/sample-zip-file.zip