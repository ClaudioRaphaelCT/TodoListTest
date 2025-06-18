# Estágio 1: Build da Aplicação
FROM eclipse-temurin:21-jdk-jammy AS build

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo de build do Gradle (build.gradle) e settings.gradle
COPY build.gradle settings.gradle ./

# Copia o resto do código da aplicação
COPY src ./src

# Para Gradle: Copia o wrapper do Gradle
COPY gradlew ./
COPY gradle ./gradle

# DÊ PERMISSÃO DE EXECUÇÃO AO WRAPPER DO GRADLE AQUI
RUN chmod +x gradlew

# Build da aplicação
RUN ./gradlew bootJar

# Estágio 2: Criação da Imagem Final
FROM eclipse-temurin:21-jre-jammy

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR construído do estágio de build
COPY --from=build /app/build/libs/*.jar app.jar

# Expõe a porta em que a aplicação Spring Boot rodará
EXPOSE 8080

# Comando para rodar a aplicação quando o contêiner iniciar
ENTRYPOINT ["java","-jar","app.jar"]