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
| IDE            | VS Code / IntelliJ IDEA             |

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
