# API Todo List — Java
A RESTful API for managing to-do tasks built with **Spring Boot 3** and **PostgreSQL**.
## Table of Contents
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Request & Response Examples](#request--response-examples)
- [Project Structure](#project-structure)
---
## Tech Stack
| Layer | Technology |
|-------|-----------|
| Language | Java 17 |
| Framework | Spring Boot 3.5.5 |
| ORM | Spring Data JPA / Hibernate |
| Database | PostgreSQL |
| Build tool | Maven (wrapper included) |
---
## Prerequisites
- **Java 17** or later
- **Maven 3.6+** (or use the included `./mvnw` wrapper)
- **PostgreSQL** running locally (default port `5432`)
---
## Configuration
1. Copy the example properties file and fill in your database credentials:
   ```bash
   cp src/main/resources/application-example.properties src/main/resources/application.properties
   ```
2. Edit `src/main/resources/application.properties`:
   ```properties
   spring.application.name=API_TODO_List
   server.port=9090
   spring.datasource.url=jdbc:postgresql://localhost:5432/<your_database>
   spring.datasource.username=<your_username>
   spring.datasource.******
   spring.datasource.driver-class-name=org.postgresql.Driver
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```
Hibernate will create or update the `Tarefa` table automatically on startup.
---
## Running the Application
```bash
# Build and run with the Maven wrapper
./mvnw spring-boot:run
# Or build a JAR first and run it
./mvnw clean package
java -jar target/API_TODO_List-0.0.1-SNAPSHOT.jar
```
The API will be available at `http://localhost:9090`.
---
## API Endpoints
All endpoints are prefixed with `/API`.
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/API/create` | Create a new task |
| `GET` | `/API/list` | List all tasks |
| `DELETE` | `/API/remove/{id}` | Delete a task by ID |
| `PUT` | `/API/concluido/{id}` | Mark a task as completed |
| `PUT` | `/API/edit/{id}` | Edit a task's details |
### Task fields
| Field | Type | Description |
|-------|------|-------------|
| `nome` | String | Task name |
| `descricao` | String | Task description |
| `tipodePrio` | String | Priority: `"Alta"` (high), `"Média"` (medium), or `"Baixa"` (low) |
| `status` | boolean | `true` = completed, `false` = pending *(read-only, set via endpoint)* |
---
## Request & Response Examples
### Create a task — `POST /API/create`
**Request body:**
```json
{
  "nome": "Buy groceries",
  "descricao": "Milk, eggs, bread",
  "tipodePrio": "Média"
}
```
**Response:**
```json
{
  "id": 1,
  "nome": "Buy groceries",
  "descricao": "Milk, eggs, bread",
  "status": false,
  "concluido": "Não concluido",
  "prioridade": 2,
  "tipodePrio": "Média"
}
```
### List all tasks — `GET /API/list`
**Response:**
```json
[
  {
    "id": 1,
    "nome": "Buy groceries",
    "descricao": "Milk, eggs, bread",
    "status": false,
    "concluido": "Não concluido",
    "prioridade": 2,
    "tipodePrio": "Média"
  }
]
```
### Mark as completed — `PUT /API/concluido/{id}`
**Response:** `"Tarefa concluida"`
### Edit a task — `PUT /API/edit/{id}`
**Request body:**
```json
{
  "nome": "Buy groceries (updated)",
  "descricao": "Milk, eggs, bread, butter",
  "tipodePrio": "Alta"
}
```
### Delete a task — `DELETE /API/remove/{id}`
**Response:** `"Tarefa removida com sucesso!"`
---
## Project Structure
```
src/
└── main/
    ├── java/com/todo/list/api_todo_list/
    │   ├── ApiTodoListApplication.java   # Application entry point
    │   └── functions/
    │       ├── Tarefa.java               # Task entity
    │       ├── TarefaController.java     # REST endpoints
    │       ├── TarefaService.java        # Business logic
    │       └── TarefaRepository.java     # Data access (JPA)
    └── resources/
        └── application-example.properties
```
