FROM adoptopenjdk/openjdk11:alpine-jre
LABEL maintainer="hendisantika@yahoo.co.id"
VOLUME /tmp
EXPOSE 8080
ADD target/springboot-advertisement-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
