FROM gradle:6.8.2-jdk11 as build-cache
# Cache is a volume so it's cleaned up after each stage / layer; remove this on proper CI setup with a volume cache
ENV GRADLE_USER_HOME /home/gradle/cache_home
ENV GRADLE_OPTS="-Dorg.gradle.daemon=false"
COPY gradle.properties *.kts ./
ADD buildSrc buildSrc
# Do not compile any sources, only buildSrc and download dependencies to use on next stage
RUN gradle clean


FROM build-cache as builder
#On proper CI setup do not reuse build-cache but mount a cache-volume as usual
ADD src src
RUN gradle bootJar


FROM adoptopenjdk:11-jre-hotspot as delayerer
COPY --from=builder /home/gradle/build/libs/*.jar ./app.jar
RUN java -Djarmode=layertools -jar app.jar extract

# see https://github.com/moby/moby/issues/37965 for RUN true  commands
FROM adoptopenjdk:11-jre-hotspot
COPY --from=delayerer /dependencies/ ./
RUN true
COPY --from=delayerer /snapshot-dependencies/ ./
RUN true
COPY --from=delayerer /spring-boot-loader/ ./
RUN true
COPY --from=delayerer /application/ ./
RUN true
CMD ["java", "org.springframework.boot.loader.JarLauncher"]
EXPOSE 8080
HEALTHCHECK --interval=20s --timeout=5s --retries=5 --start-period=40s \
    CMD curl --fail --silent localhost:8080/actuator/health 2>&1 | grep UP || exit 1
