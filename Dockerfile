FROM openjdk:13.0.2
VOLUME /tmp
ADD target/statistics-0.0.1-SNAPSHOT.jar statistics-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","statistics-0.0.1-SNAPSHOT.jar"]

