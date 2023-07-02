FROM alpine:latest

RUN apk update && apk add openjdk17

RUN mkdir /root/backend-spring
COPY . /root/backend-spring
WORKDIR /root/backend-spring
RUN chmod 755 ./gradlew
#RUN ./gradlew build

ENTRYPOINT ["tail", "-f", "/dev/null"]
#ENTRYPOINT ["./gradlew","build"]
#ENTRYPOINT ["java", "-jar", "build/libs/DeepSea-0.0.1-SNAPSHOT.jar"]

