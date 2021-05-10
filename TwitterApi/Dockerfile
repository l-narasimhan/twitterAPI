FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar

EXPOSE 8105
EXPOSE 8101
EXPOSE 8080
EXPOSE 8081
EXPOSE 1521
EXPOSE 9010
EXPOSE 8102
EXPOSE 8110
COPY wait-for-it.sh .
COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java", "-Dspring.profiles.active=oracle",
# "-Dcom.sun.management.jmxremote=true" ,
# "-Dcom.sun.management.jmxremote.local.only=false",
#"-Dcom.sun.management.jmxremote.authenticate=false",
# "-Dcom.sun.management.jmxremote.ssl=false",
# "-Djava.rmi.server.hostname=localhost",
# "-Dcom.sun.management.jmxremote.port=9010",
# "-Dcom.sun.management.jmxremote.rmi.port=9010",
# "-jar",
#"/app.jar"]
CMD java \
 -Dcom.sun.management.jmxremote=true \
 -Dcom.sun.management.jmxremote.local.only=false \
 -Dcom.sun.management.jmxremote.authenticate=false \
 -Dcom.sun.management.jmxremote.ssl=false \
 -Djava.rmi.server.hostname=localhost \
 -Dcom.sun.management.jmxremote.port=9010 \
 -Dcom.sun.management.jmxremote.rmi.port=9010 \
 -Dspring.profiles.active=oracle \
 -Xms256m -Xmx1024m -jar /app.jar

