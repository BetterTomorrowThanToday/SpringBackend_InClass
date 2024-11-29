FROM eclipse-temurin:17-jdk AS builder

EXPOSE 8080

WORKDIR /app

COPY . .

RUN ./gradlew build -x test --no-daemon

FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]