FROM openjdk:11
VOLUME /tmp
EXPOSE 8090
ADD ./target/api-foto-mongodb-0.0.1-SNAPSHOT.jar api-foto-mongodb.jar
ENTRYPOINT ["java","-jar","/api-foto-mongodb.jar"]