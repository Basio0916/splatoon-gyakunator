# Build stage
FROM sbtscala/scala-sbt:eclipse-temurin-17.0.4_1.7.1_3.2.0 AS build
WORKDIR /app
COPY . .
RUN sbt dist

# Final stage
FROM openjdk:11-jre
WORKDIR /app
COPY --from=build /app/target/universal/*.zip ./
RUN unzip *.zip && rm *.zip && mv * backend
CMD ["backend/bin/splatoon-gyakunator"]