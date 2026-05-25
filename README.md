# FirstRestAPI

This project is a simple REST API application built with Spring Boot.

## Technologies

* Java 17
* Spring Boot
* Maven
* Swagger UI
* H2 Database
* Spring Data JPA

## Run Project

```bash
mvn spring-boot:run
```

Application starts on:

```text
http://localhost:8080
```

## Swagger UI

```text
http://localhost:8080/swagger-ui/index.html
```

## H2 Console

```text
http://localhost:8080/console
```

JDBC URL:

```text
jdbc:h2:mem:testdb
```

## API Endpoints

| Method | Endpoint |
| :--- | :--- |
| GET | `/api/v1/products` |
| GET | `/api/v1/products/{id}` |
| POST | `/api/v1/products` |
| PUT | `/api/v1/products/{id}` |
| DELETE | `/api/v1/products/{id}` |

## Features

* Create product
* Get product by id
* Get all products
* Update product
* Delete product
* Exception handling
* Swagger documentation
* H2 in-memory database

## Swagger UI Screenshot

<img width="1919" height="940" alt="image" src="https://github.com/user-attachments/assets/2602c579-ecc6-4fdb-bf8a-715e5980012f" />

