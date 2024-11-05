# Inventory Service
Demo for educational purposes.


## Requirements

For building and running the application you need:

- [JDK 17](https://adoptium.net/temurin/releases/?version=17)
- [Maven 3](https://maven.apache.org/download.cgi)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.system.chat.SpringChatApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
## Deploying the application

Navigate to the root folder project with your preferred shell and run:

```shell
mvnw clean package
```
it will create .jar file in the /target folder at the same level.

You can run the file just using:

```shell
java -jar SpringChat-<VERSION>.jar
```
## Tooling

The project offers the following tools to facilitate data access and manipulation:

http://localhost:8090/graphiql

http://localhost:8090/h2-console
