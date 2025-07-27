
# 🎉 Eventify – Microservices Event Management System

**Eventify** is a microservices-based event booking system built using Java Spring Boot. It showcases real-world architectural patterns like service decomposition, asynchronous messaging with Kafka, performance optimization using Redis, and service discovery with Eureka.

---

## 🏗️ Architecture Overview

- **API Gateway** – Entry point for all client requests (Spring Cloud Gateway)
- **Eureka Server** – Service registry and discovery
- **Event Service** – Manages event creation and details
- **Booking Service** – Handles user bookings for events
- **Notification Service** – Sends confirmations and alerts
- **Kafka** – For decoupled communication between services
- **Redis** – Used for caching and rate limiting

```
User → API Gateway → Microservice → Redis
```

---

## ⚙️ Tech Stack

| Layer            | Technology               |
|------------------|--------------------------|
| Language         | Java 17                  |
| Framework        | Spring Boot              |
| Messaging Queue  | Apache Kafka             |
| Caching/Storage  | Redis                    |
| Build Tool       | Maven                    |
| Service Discovery| Eureka                   |
| API Gateway      | Spring Cloud Gateway     |
| Containerization | Docker (planned)         |

---

## 🚀 Features

- 🎫 Create and manage events
- 📅 Book events as a user
- 📩 Get notifications on successful bookings
- 🌐 Service discovery with Eureka
- 🚪 Centralized entry via API Gateway
- ⚡ **Redis-powered caching** for faster API responses
- 🔒 **Rate limiting** using Redis to prevent abuse

---

## 📸 Redis in Action

- **Faster reads**: Frequently accessed event data is cached.
- **Rate limiting**: Controls how often a user can hit the API.
- **Session storage**: For temporary user/session state (optional).

---

## 📦 Project Structure

```
eventify/
├── api-gateway/
├── eureka-server/
├── event-service/
├── booking-service/
├── notification-service/
├── common/              # Shared configs, DTOs, utils
└── docker-compose.yml   # Coming soon!
```

---

## 🛠️ Getting Started (Local Setup)

1. **Clone the repo**
   ```bash
   git clone https://github.com/your-username/eventify.git
   cd eventify
   ```

2. **Start Redis locally**
   ```bash
   docker run -p 6379:6379 redis
   ```

3. **Start Kafka & Zookeeper**  
   You can use Docker Compose or Confluent CLI.

4. **Run each microservice**
   Navigate into each service folder and run:
   ```bash
   mvn spring-boot:run
   ```

---

## 🔮 Upcoming Features

- ✅ Docker + Docker Compose for deployment
- ✅ Swagger/OpenAPI docs
- ✅ Redis for session storage and authentication

---

## 🤝 Contributing

Have suggestions or improvements? Open an issue or PR — collaboration is always welcome!

---

## 🧠 Author

**Pranjal Bansal**  
Java Backend Developer | Open Source Enthusiast  
📫 [LinkedIn](https://www.linkedin.com/in/pranjalbansal) • [GitHub](https://github.com/your-username)

---

## ⭐️ Show your support

If you found this project useful, consider giving it a ⭐ on GitHub!
