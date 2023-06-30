#!/bin/zsh

./gradlew build
nohup java -jar build/libs/DeepSea-0.0.1-SNAPSHOT.jar &
