FROM openjdk:8-jdk-alpine

ADD ./build/libs/flow-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/flow-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080