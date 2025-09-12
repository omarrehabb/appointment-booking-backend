# Appointment Booking (Backend)

A Spring Boot–powered REST API for managing appointments.  
Supports full CRUD on appointments, in‑memory H2 database, Basic Auth security, and ready for integration with an Angular frontend.

---

## Table of Contents

- [Features](#features)  
- [Tech Stack](#tech-stack)  
- [Prerequisites](#prerequisites)  
- [Getting Started](#getting-started)  
  - [Clone & Build](#clone--build)  
  - [Configuration](#configuration)  
  - [Run the App](#run-the-app)  
- [API Endpoints](#api-endpoints)  
  - [Authentication](#authentication)  
  - [Appointments](#appointments)  
- [In‑Memory Console (H2)](#in-memory-console-h2)  
- [Testing](#testing)  
- [Next Steps](#next-steps)  
- [Contributing](#contributing)  
- [License](#license)  

---

## Features

- 📋 CRUD endpoints for appointments  
- 🚀 Spring Boot 3.5.3, Java 21  
- 🔒 Basic Authentication (`admin` / `admin123`)  
- 🗄️ H2 in‑memory database  
- 🔄 DevTools for hot reload  

---

## Tech Stack

| Layer          | Technology                          |
| -------------- | ----------------------------------- |
| Framework      | Spring Boot                         |
| Web            | Spring Web, Spring Security         |
| Data & JPA     | Spring Data JPA, Hibernate, H2 DB   |
| Build & Test   | Maven Wrapper, JUnit, Mockito       |
| IDE            | VS Code                             |

---

## Prerequisites

- Java 21 JDK  
- Maven (or use the bundled `mvnw` / `mvnw.cmd`)  
- Git  

---

## Getting Started

### Clone & Build

```bash
git clone https://github.com/omarehab/appointment-booking.git
cd appointment-booking/backend
./mvnw clean package
# Appointment Booking (Backend)

Spring Boot 3.5 (Java 21) REST API for managing appointments. Includes a small JSP-based demo UI under `/appointments` and a CORS-enabled REST controller under `/api/appointments` for the Angular frontend.

---

## Features

- CRUD endpoints for appointments under `/api/appointments`
- H2 in-memory database (schema managed by JPA)
- Basic auth configured globally; API endpoints are currently open
- CORS allowed for `http://localhost:4200`

---

## Prerequisites

- JDK 21
- Maven (or use the included wrapper `./mvnw` / `mvnw.cmd`)

---

## Run Locally

From `appointment-booking-backend/`:

```
./mvnw spring-boot:run
```

Or build a jar and run it:

```
./mvnw clean package
java -jar target/appointment-booking-*.jar
```

Default port: `8080`

---

## Configuration

`src/main/resources/application.properties` contains defaults:

- In-memory H2: `spring.datasource.url=jdbc:h2:mem:testdb`
- JPA: `spring.jpa.hibernate.ddl-auto=update`
- Global basic auth user: `admin` / `admin123`
- View resolver for JSPs under `/WEB-INF/jsp/`

Security note: `SecurityConfig` permits all requests to `/api/**` and requires authentication for other paths. If you want to protect the API with basic auth, change the authorization rules accordingly and remove the `.permitAll()` for `/api/**`.

---

## REST API

Base path: `http://localhost:8080/api/appointments`

DTO shape:

```
{
  "id": number,
  "clientName": string,
  "startTime": string,  // ISO-8601, e.g. 2025-09-12T10:00:00
  "endTime": string,    // ISO-8601
  "notes": string | null,
  "confirmed": boolean
}
```

Endpoints:

- `GET    /api/appointments` → list all appointments
- `GET    /api/appointments/{id}` → get one
- `POST   /api/appointments` → create (201)
- `PUT    /api/appointments/{id}` → update
- `DELETE /api/appointments/{id}` → delete (204)

Examples:

```
curl http://localhost:8080/api/appointments

curl -X POST http://localhost:8080/api/appointments \
  -H 'Content-Type: application/json' \
  -d '{
        "clientName": "Alice",
        "startTime": "2025-09-12T10:00:00",
        "endTime":   "2025-09-12T11:00:00",
        "notes":     "First visit",
        "confirmed": false
      }'
```

---

## JSP Demo Pages (secured)

- `GET /appointments` → list view (requires basic auth)
- `GET /appointments/new` → form view (requires basic auth)
- `POST /appointments` → create via form

Use the default credentials: `admin` / `admin123`.

---

## CORS

`@CrossOrigin(origins = "http://localhost:4200")` is enabled on the REST controller for local Angular dev.

---

## Notes & Tips

- Data is in-memory (H2) and will reset on restart. To enable H2 console, you can add `spring.h2.console.enabled=true` if needed.
- Logs include Spring Security debug for easier development: see `logging.level.org.springframework.security=DEBUG`.
