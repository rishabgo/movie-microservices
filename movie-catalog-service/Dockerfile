FROM openjdk:8
EXPOSE 8080
ADD target/movie-catalog-service-0.0.1-SNAPSHOT.jar movie-catalog-service.jar
ENTRYPOINT ["java","-jar","/movie-catalog-service.jar"]