FROM openjdk:11

WORKDIR /app/
COPY . /app/

CMD ["./mvnw", "compile", "quarkus:dev"]