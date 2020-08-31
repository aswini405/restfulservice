#
# Dockerfile for creating Docker container hosting Cassandra query service
#

#FROM docker.axone.am.health.ge.com:5043/coral:0.1.0-SNAPSHOT
#FROM docker.axone.am.health.ge.com:5043/centos7-jre8u66:0.1
FROM openjdk:8-jdk
#FROM nginx:alpine
# Service base folder
ENV SVC_ROOT /svc
 
#create servcie folders
RUN mkdir -p $SVC_ROOT/jar/; mkdir -p $SVC_ROOT/lib/; mkdir -p $SVC_ROOT/resources/;


#Add dependencies, scripts, resources
ADD target/restfulservice-0.0.1-SNAPSHOT.jar $SVC_ROOT/jar/
ADD target/classes/* $SVC_ROOT/classes/
ADD entry.sh $SVC_ROOT/resources/entry.sh
 
RUN chmod 777 $SVC_ROOT/resources/entry.sh

ENV LD_LIBRARY_PATH $SVC_ROOT/lib


# SET working directory
WORKDIR $SVC_ROOT/resources






ENTRYPOINT ["sh","-c","/svc/resources/entry.sh" ]


