FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD task-manage.jar task-manage.jar
RUN echo "Asia/Shanghai" > /etc/timezone
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/task-manage.jar"]