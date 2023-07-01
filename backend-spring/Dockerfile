FROM openjdk:17-alpine

RUN mkdir backend-spring
WORKDIR /backend-spring
COPY . .
RUN chmod 755 ./gradlew

ENTRYPOINT ["./gradlew","build"]
#ENTRYPOINT ["bash"]

