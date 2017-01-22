FROM java:8
ADD target/movie-microservice-0.0.1.jar app.jar
EXPOSE 2222
CMD ["java", "-jar","app.jar"]
