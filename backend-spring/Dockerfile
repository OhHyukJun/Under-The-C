FROM alpine:latest

RUN apk update && apk add openjdk17

#RUN mkdir /root/backend-spring
COPY . /backend-spring
WORKDIR /backend-spring
RUN chmod 755 ./fastbuild.sh

#RUN addgroup -g 1000 appuser
#RUN adduser -D -u 1000 -G appuser appuser

#USER appuser
#RUN ./gradlew build

ENTRYPOINT ["sh", "fastbuild.sh"]
#ENTRYPOINT ["tail", "-f", "/dev/null"]
#ENTRYPOINT ["./gradlew","build"]
#ENTRYPOINT ["java", "-jar", "build/libs/DeepSea-0.0.1-SNAPSHOT.jar"]

