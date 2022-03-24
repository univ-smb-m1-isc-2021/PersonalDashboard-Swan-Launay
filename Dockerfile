FROM openjdk:17-slim

COPY ./target/PersonalDashboard-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD ["sh","-c","java -XX:InitialRAMPercentage=50 -XX:MaxRAMPercentage=70  -XshowSettings $JAVA_OPTS -jar PersonalDashboard-0.0.1-SNAPSHOT.jar "]
