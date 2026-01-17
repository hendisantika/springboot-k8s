# Spring Boot Kubernetes Demo Application

A Spring Boot application demonstrating deployment on Kubernetes with MySQL database integration.

## Technologies Used

- **Java 25**
- **Spring Boot 4.0.1**
- **Spring Data JPA**
- **Spring Security with OAuth2 Client**
- **MySQL Database**
- **Kubernetes**
- **Docker**
- **Gradle 9.2.1**
- **Lombok**

## Project Structure

The project includes the following main components:

### Models
- **User** - User entity with hobbies collection
- **Employee** - Employee entity with department relationship
- **Department** - Department entity with employees
- **Author** - Author entity with books relationship
- **Book** - Book entity with author relationship

### Repositories
- UserRepository
- EmployeeRepository
- DepartmentRepository
- AuthorRepository
- BookRepository

### Services
- UserService (with caching support)
- EmployeeService
- DepartmentService
- AuthorService
- BookService
- PaymentService

### Components
- Payment interface implementations (CreditCard, Paypal)
- Transaction interface
- Cache component for demonstrating caching

## Prerequisites

- Java 25 or higher
- Docker (for running MySQL locally)
- Kubernetes cluster (for deployment)
- kubectl (Kubernetes CLI)

## Database Configuration

### Local Development
The application is configured to connect to MySQL:

```properties
Database URL: jdbc:mysql://localhost:3306/k8s
Username: root
Password: root
```

### Kubernetes Deployment
The Kubernetes configuration uses:
```properties
Database: demo_spring
Username: root
Password: password
```

## Building the Project

### Build JAR file
```bash
./gradlew clean build
```

### Build without tests
```bash
./gradlew clean build -x test
```

### Run tests only
```bash
./gradlew test
```

## Running Locally

### 1. Start MySQL Database
You can use Docker to run MySQL locally:

```bash
docker run --name mysql-local -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=k8s -p 3306:3306 -d mysql:8.0
```

### 2. Run the Application
```bash
./gradlew bootRun
```

Or run the JAR file directly:
```bash
java -jar build/libs/springboot-k8s-0.0.1-SNAPSHOT.jar
```

## Kubernetes Deployment

The project includes Kubernetes configuration files for deploying both the application and MySQL database.

### 1. Deploy MySQL Database
```bash
kubectl apply -f k8s-db.yaml
```

This will create:
- PersistentVolumeClaim (1Gi storage)
- MySQL Deployment (using mysql:5.7 image)
- MySQL Service (ClusterIP)

### 2. Deploy Spring Boot Application
```bash
kubectl apply -f k8s-app.yaml
```

This will create:
- Spring Boot Deployment (3 replicas)
- Service (NodePort type)

### 3. Verify Deployment
```bash
# Check pods status
kubectl get pods

# Check services
kubectl get services

# Check deployments
kubectl get deployments
```

### 4. Access the Application
After deployment, get the NodePort:
```bash
kubectl get service springboot-crud-svc
```

Access the application at:
```
http://<node-ip>:<node-port>
```

## Docker Compose

The project includes a `compose.yaml` file for Docker Compose deployment (currently empty - needs to be configured).

## Features Demonstrated

- **JPA Relationships**: One-to-Many, Many-to-One mappings
- **Caching**: Spring Cache abstraction
- **Security**: Spring Security with OAuth2 configuration
- **Design Patterns**: Singleton pattern, Interface-based design
- **Kubernetes**: Deployment, Services, PersistentVolumeClaim
- **Multi-threading**: Examples with Thread and Runnable

## Configuration Notes

### Security
The application uses Spring Security with OAuth2 Client. For production use, configure OAuth2 client credentials in `application.properties`:

```properties
spring.security.oauth2.client.registration.<provider>.client-id=your-client-id
spring.security.oauth2.client.registration.<provider>.client-secret=your-client-secret
```

### Actuator
Spring Boot Actuator is included for monitoring and management endpoints.

### Validation
Bean Validation (JSR 303) is enabled for request validation.

## Development

### Code Style
- Uses Lombok annotations to reduce boilerplate code
- Follows Spring Boot best practices
- Implements repository pattern with Spring Data JPA

### Database Schema
The application uses `spring.jpa.hibernate.ddl-auto=update` which automatically creates/updates database schema based on entities.

## Known Issues

- Tests require OAuth2 configuration to pass
- Docker Compose file needs to be configured with MySQL service
- The k8s-app.yaml uses a public Docker image (`bharathdayal/demok8s:latest`) - you may need to build and push your own image

## Building Docker Image

To build your own Docker image:

1. Build the JAR:
```bash
./gradlew bootJar
```

2. Create Dockerfile (if not exists):
```dockerfile
FROM eclipse-temurin:25-jre
COPY build/libs/springboot-k8s-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

3. Build and push:
```bash
docker build -t <your-registry>/springboot-k8s:latest .
docker push <your-registry>/springboot-k8s:latest
```

4. Update k8s-app.yaml with your image name.

## Contributing

Feel free to submit issues and enhancement requests!

## Author

**Hendi Santika**
- Email: hendisantika@yahoo.co.id
- Telegram: @hendisantika34
- Link: s.id/hendisantika

## License

This project is open source and available for learning purposes.
