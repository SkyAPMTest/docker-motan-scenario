FROM openjdk:8u111-jdk

ENV SERVER_LIST=127.0.0.1:34000 \
    USER_ID=test \
    APPLICATION_CODE=test

RUN  mkdir /motan & mkdir -p /usr/local/agent

COPY docker-motan.jar /motan
COPY start.sh  /motan

RUN chmod +x /motan/start.sh

# agent jar file
VOLUME /usr/local/agent

#JPDA
EXPOSE 8000 8080

ENTRYPOINT ["/motan/start.sh"]