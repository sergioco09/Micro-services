FROM java:8-jdk-alpine
MAINTAINER sergio.chacon@elektra.com.mx

#ARG PROJECT_NAME

WORKDIR /opt/ssl/dev
WORKDIR /opt/ssl/qa
WORKDIR /opt/ssl/prod
WORKDIR /opt/ssl/oregon


COPY target/gestionNotificaciones-0.0.1-SNAPSHOT.jar /opt/gestionNotificaciones-0.0.1-SNAPSHOT.jar


#	CERTIFICADOS JKS DEV
COPY ssl/DEV/kafka.client.keystore.jks /opt/ssl/dev/kafka.client.keystore.jks
COPY ssl/DEV/kafka.client.truststore.jks /opt/ssl/dev/kafka.client.truststore.jks

#	CERTIFICADOS JKS QA
COPY ssl/QA/kafka.client.keystore.jks /opt/ssl/qa/kafka.client.keystore.jks
COPY ssl/QA/kafka.client.truststore.jks /opt/ssl/qa/kafka.client.truststore.jks

#	CERTIFICADOS JKS PROD
COPY ssl/PROD/kafka.client.keystore.jks /opt/ssl/prod/kafka.client.keystore.jks
COPY ssl/PROD/kafka.client.truststore.jks /opt/ssl/prod/kafka.client.truststore.jks

#	CERTIFICADOS JKS OREGON
COPY ssl/OREGON/kafka.client.keystore.jks /opt/ssl/oregon/kafka.client.keystore.jks
COPY ssl/OREGON/kafka.client.truststore.jks /opt/ssl/oregon/kafka.client.truststore.jks


EXPOSE 8085

ENTRYPOINT ["java", "-jar", "/opt/gestionNotificaciones-0.0.1-SNAPSHOT.jar"]
