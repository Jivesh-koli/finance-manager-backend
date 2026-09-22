# finance Manager – Backend

A personal finance management backend built with Spring Boot, PostgreSQL, and JPA/Hibernate.
Users can create accounts and track expenses through a RESTful API, following a 
Controller → Service → Repository layered architecture.

## Tech Stack

`Java` `Spring Boot` `PostgreSQL` `Hibernate` `Spring Data JPA` `Maven`

## Architecture

Controller → Service → Repository → PostgreSQL

**Entities:** User (1) — (many) Expense

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | /users | Create user |
| GET | /users | List all users |
| GET | /users/{id} | Get user by ID |
| POST | /expenses | Add expense |
| GET | /expenses | List all expenses |
| GET | /expenses/{id} | Get expense by ID |
| PUT | /expenses/{id} | Update expense |
| DELETE | /expenses/{id} | Delete expense |
| GET | /users/{userId}/expenses | Get user's expenses |
| GET | /expenses/category/{category} | Filter by category |

## Setup

```bash
git clone https://github.com/<your-username>/finance-manager-backend.git
cd finance-manager-backend
# configure application.properties with your PostgreSQL credentials
mvn spring-boot:run
```

## Progress

**Done:**
- [x] Entity modeling (User, Expense) with One-to-Many relationship
- [x] Repository layer (Spring Data JPA)
- [x] Service layer with business logic
- [x] REST controllers (full CRUD)

**In Progress:**
- [ ] Wire DTOs (UserRequestDto/UserResponseDto) into controller — currently exposing entities directly
- [ ] Input validation (negative amounts, empty fields, email format)
- [ ] Password encryption (BCrypt)
- [ ] Spring Security + JWT authentication
- [ ] Global exception handling (@ControllerAdvice)
- [ ] Unit/integration tests (JUnit, Mockito)
- [ ] Deployment (Render/Railway)