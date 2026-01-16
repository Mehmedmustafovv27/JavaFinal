# Final Spring Boot Project

This project is a RESTful Spring Boot application developed in Java 17.

## Technologies
- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 in-memory database
- Swagger (OpenAPI)
- Maven

## Project Structure
The application follows a layered architecture:
- **model** – JPA entities
- **repository** – data access layer
- **service** – business logic
- **rest** – REST controllers
- **dto & mapper** – data transfer objects and mapping
- **test** – JPA repository tests

## Database & Relations
- Minimum of 5 database tables
- **ManyToOne** relationship (Visit → Vet, Visit → Pet)
- **ManyToMany** relationship (Vet ↔ Specialty)

## Features
- CRUD operations for main entities
- Custom business logic for visits
- Custom `@Query` in repository
- DTO usage instead of exposing entities directly
- Swagger UI for API documentation

