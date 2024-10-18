FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/ms-gestion-trabajadores-0.0.1.jar
COPY ${JAR_FILE} ms-gestion-trabajadores.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "ms-gestion-trabajadores.jar" ] 