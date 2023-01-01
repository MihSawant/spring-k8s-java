FROM maven:3.8.6-eclipse-temurin-17 as BUILD

ADD repository.tar.gz /usr/share/maven/ref
COPY . /usr/src/app
WORKDIR /usr/src/app
RUN mvn -s /usr/share/maven/ref/settings-docker.xml package


FROM eclipse-temurin:17-jre
EXPOSE 8080 5005
COPY --from=BUILD /usr/src/app/target /opt/target
WORKDIR /opt/target
ENV _JAVA_OPTIONS '-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005'

CMD ["java", "-jar", "spring-k8s-ready.jar"]
