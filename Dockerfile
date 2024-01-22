FROM openjdk:17-oracle

WORKDIR /app

COPY target/grocerybooking-1.0.jar /app/grocerybooking-1.0.jar

EXPOSE 8080

CMD ["java", "-jar", "grocerybooking-1.0.jar"]
