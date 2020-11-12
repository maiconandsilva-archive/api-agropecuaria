FROM openjdk:11

WORKDIR /app/
COPY . /app/

ENTRYPOINT ["./mvnw"]
CMD ["compile", "quarkus:dev"]