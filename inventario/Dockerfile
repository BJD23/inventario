# Etapa 1: Build con Gradle
FROM gradle:8.8-jdk21 AS build
WORKDIR /app
COPY . .
RUN bash gradlew build -x test --no-daemon

#Etapa 2 Imagen Ligera de runetime (produccion)
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

#Se copia el jar generado en la etapa de build
COPY --from=build /app/build/libs/*.jar app.jar

#Exponer el puerto de la aplicación
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

# Para construir la imagen: docker build -t inventario-app .
# Para correr el contenedor: docker run -p 8080:8080 inventario
# Para probar la API: curl http://localhost:8080/api/productos