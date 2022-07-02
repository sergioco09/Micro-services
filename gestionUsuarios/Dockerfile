FROM java:8-jdk-alpine
MAINTAINER sergio.chacon@elektra.com.mx

COPY target/gestionUsuarios-0.0.1-SNAPSHOT.jar /opt/gestionUsuarios-0.0.1-SNAPSHOT.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "/opt/gestionUsuarios-0.0.1-SNAPSHOT.jar"]
