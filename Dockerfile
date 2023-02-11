FROM gradle:7.6-jdk17-alpine AS builder
WORKDIR /app
COPY . /app
RUN gradle bootJar

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/build/libs/kameleoon-trial-task-1.0.jar /app/ktt.jar

ENTRYPOINT ["java"]
CMD ["-jar", "ktt.jar"]
