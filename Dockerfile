FROM openjdk:21-bookworm
COPY "./target/repository-service-0.0.2-SNAPSHOT.jar" "repository-service-0.0.2.jar"
EXPOSE 80/tcp
ENTRYPOINT ["java","-jar","/repository-service-0.0.2.jar"]