# Estágio 1: Build da Aplicação
FROM eclipse-temurin:21-jdk-jammy AS build

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo de build do Gradle/Maven (pom.xml ou build.gradle)
# Isso permite que o Docker use o cache para as dependências se o pom.xml/build.gradle não mudar
COPY build.gradle settings.gradle ./
# Para Maven: COPY pom.xml ./

# Copia o resto do código da aplicação
COPY src ./src

# Para Gradle: Copia o wrapper do Gradle (se você usar)
COPY gradlew ./
COPY gradle ./gradle

# Dá permissão de execução ao wrapper do Gradle
# RUN chmod +x gradlew

# Build da aplicação
# Para Gradle:
RUN ./gradlew bootJar

# Para Maven:
# RUN mvn clean package -DskipTests

# Estágio 2: Criação da Imagem Final
FROM eclipse-temurin:21-jre-jammy

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR construído do estágio de build
# Para Gradle:
COPY --from=build /app/build/libs/*.jar app.jar

# Para Maven:
# COPY --from=build /app/target/*.jar app.jar

# Expõe a porta em que a aplicação Spring Boot rodará
EXPOSE 8080

# Comando para rodar a aplicação quando o contêiner iniciar
ENTRYPOINT ["java","-jar","app.jar"]

# Opcional: Variáveis de ambiente para configurar a porta (melhor ser externa)
# ENV SERVER_PORT=8080