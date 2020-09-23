FROM gradle:6.6.1-jdk11

LABEL maintainer="\"Juan Ara\" <bofh@juanylaura.es>"

USER root

ENV GRADLE_OPTS="-Dorg.gradle.daemon=false"

RUN mkdir app
VOLUME /home/gradle/app
WORKDIR /home/gradle/app

ENTRYPOINT ["gradle"]

CMD ["build"]
