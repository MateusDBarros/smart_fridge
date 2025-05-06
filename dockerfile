# Use imagem oficial do Java como base
FROM openjdk:21-jdk-slim

# Define diretório de trabalho
WORKDIR /app

# Copia o JAR compilado
COPY target/smart_fridge-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta do app
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
