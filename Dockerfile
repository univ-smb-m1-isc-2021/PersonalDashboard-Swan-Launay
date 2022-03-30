FROM openjdk:17-slim

COPY ./target/personal-dashboard-1.0-SNAPSHOT.jar .

EXPOSE 8080

CMD ["sh","-c","java -XX:InitialRAMPercentage=50 -XX:MaxRAMPercentage=70  -XshowSettings $JAVA_OPTS -jar personal-dashboard-1.0-SNAPSHOT.jar"]
