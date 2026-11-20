# 🏎️ F1 Teams & Drivers Management System

A distributed system for managing Formula 1 teams and drivers, built with a microservices architecture, REST APIs, and an Angular web application.

---

## 📋 About the Project

The **F1 Teams & Drivers Management System** provides comprehensive management of racing teams and the drivers representing them. The project is designed for high scalability, reliability, and ease of deployment through containerization, service discovery, and load balancing mechanisms.

### Domain Model
The system is based on a `1:N` relationship between two core entities:
- **Team (`Team` / `Zespol`):** A category representing an F1 constructor/team (e.g., *Red Bull Racing, Ferrari, McLaren*).
- **Driver (`Driver` / `Kierowca`):** An element representing a driver assigned to a specific team (e.g., *Max Verstappen, Charles Leclerc*).

---

## 🏛️ System Architecture

The system consists of independent components cooperating in a distributed environment:

1. **`team-service` (Spring Boot):** A microservice responsible for managing F1 teams.
2. **`driver-service` (Spring Boot):** A microservice managing drivers, capable of running multiple instances with load balancing.
3. **`api-gateway` (Spring Cloud Gateway):** A single point of entry routing client requests to the appropriate microservices.
4. **`discovery-service` (Spring Cloud Eureka):** A service registry enabling dynamic discovery of microservices and their instances.
5. **`config-service` (Spring Cloud Config):** A centralized configuration server providing environment settings.
6. **Frontend (Angular & NGINX):** An interactive Single Page Application (SPA) served by an NGINX HTTP server.
7. **Relational Databases:** Dedicated databases for individual services with automated schema migration upon startup.

---

## ✨ Features

- **Team Management:**
  - Browse the list of all constructors and teams.
  - Add new teams and edit existing data (e.g., number of Constructors' Championships won).
  - Delete a team with cascading deletion of its assigned drivers.
  - View team details along with a complete list of its drivers.

- **Driver Management:**
  - Register and add new drivers to a selected team.
  - Edit driver details (e.g., racing number or name).
  - Remove drivers from the system.
  - View detailed information about an individual driver.

- **Event-Driven Communication:**
  - Automatic state synchronization of relationships between services when changes occur in the team structure.

---

## 🛠️ Tech Stack

- **Backend:** Java, Spring Boot, Spring Data JPA, Spring MVC, Spring Cloud (Gateway, Eureka Discovery, Config)
- **Frontend:** Angular, TypeScript, HTML5/SCSS, NGINX
- **Databases & Migrations:** PostgreSQL / MySQL, Liquibase / Flyway
- **Tools & Containerization:** Apache Maven, Project Lombok, Docker, Docker Compose

---

## 🚀 Getting Started

The entire environment can be easily launched using **Docker Compose**.

### Prerequisites:
- [Docker](https://www.docker.com/) and Docker Compose installed.

### Installation & Running:

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/your-username/f1-teams-drivers.git](https://github.com/your-username/f1-teams-drivers.git)
   cd f1-teams-drivers
   Start the environment in containers:
2. **Start the environment in containers:**
docker-compose up --build

3. **Access the application:**
Web Interface (Angular): http://localhost:80
API Gateway: http://localhost:8080
Eureka Discovery Console: http://localhost:8761
