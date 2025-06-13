FROM openjdk:17-jdk-alpine
WORKDIR /app
# Tener en cuenta que docker no recibe los nombres en mayuscula solo en minuscula
# El path debe ser desde target(path relative)
COPY target/InventorySystem-0.0.1-SNAPSHOT.jar InventorySystem.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/InventorySystem.jar"]