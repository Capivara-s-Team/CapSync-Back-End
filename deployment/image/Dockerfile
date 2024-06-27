FROM maven:3.9.7-eclipse-temurin-17
WORKDIR /app

RUN git clone -b develop https://github.com/Capivara-s-Team/CapSync-Back-End.git

COPY . /app

WORKDIR /app/CapSync-Back-End

RUN mvn clean package -DskipTests

RUN cp target/*.jar /app/CapSync-Back-End.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/CapSync-Back-End.jar"]