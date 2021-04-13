FROM amazoncorretto:11-alpine AS BUILD
ENV HOME=/usr/app
WORKDIR $HOME
COPY . $HOME
RUN ./gradlew clean build

FROM amazoncorretto:11-alpine
ENV JAR_FILE=myrecipick-api-0.0.1-SNAPSHOT.jar
ENV HOME=/usr/app

WORKDIR $HOME
COPY --from=BUILD  $HOME/myrecipick-api/build/libs/$JAR_FILE .
EXPOSE 8080
ENTRYPOINT java -jar $JAR_FILE