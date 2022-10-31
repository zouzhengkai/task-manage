#!/bin/sh

service_name=task-manage
image_version=1.0-SNAPSHOT

containerId=$(docker ps -a | grep -E "${service_name}" | awk '{print $1}')

if [ ! -z $containerId ]
  then docker stop $containerId && docker rm $containerId
fi

imageId=$(docker images | grep -E "^${service_name}" | awk '{print $3}')
if [ ! -z $imageId ]
  then docker rmi $imageId
fi
cd ../..
mvn clean install

mvn clean package -Dmaven.test.skip=true docker:build

docker run --name=${service_name} --privileged=true -p 8080:8080 \
       -t ${service_name}:${image_version}
