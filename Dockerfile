FROM openjdk:8-jre-alpine

MAINTAINER Samlet Wu, xiaofei.wu@gmail.com

ENV JAVA_OPTIONS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV AB_ENABLED=jmx_exporter
COPY target/lib/* /deployments/lib/
COPY target/*-runner.jar /deployments/app.jar
RUN mkdir -p /deployments/resources
ADD resources /deployments/resources/

WORKDIR /deployments

CMD java -cp app.jar:lib/* sagas.rules.ApplicaEntryPoint

EXPOSE 4333 4334
