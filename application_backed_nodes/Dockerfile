FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/application_backed_nodes-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_nodes.jar
EXPOSE 5000
ENTRYPOINT ["java", "-jar", "app_nodes.jar"]