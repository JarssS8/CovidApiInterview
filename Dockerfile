#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS buildCovid
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY ./target/covid_20052022_AdrianCorral-0.0.1-SNAPSHOT.jar /usr/local/lib/CovidApp.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/CovidApp.jar"]