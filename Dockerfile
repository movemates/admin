FROM eclipse-temurin:17-jdk-alpine

EXPOSE 8080

COPY /build/libs/admin-0.0.1-SNAPSHOT.jar /src/
WORKDIR /src

ENTRYPOINT ["java","-jar","admin-0.0.1-SNAPSHOT.jar"]
CMD echo "Container is running..."
