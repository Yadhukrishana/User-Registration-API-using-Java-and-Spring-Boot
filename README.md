Sure, here is the README file formatted for GitHub:

---

# User Registration, Validation, Viewing, and Deleting using Java and Spring Boot

This project is a User Management CRUD (Create, Read, Update, Delete) application built using Java and Spring Boot. The application provides APIs for user registration, user validation, retrieving all registered users, and deleting users by email.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Running the Application](#running-the-application)
- [Testing the APIs](#testing-the-apis)
  - [1. User Registration](#1-user-registration)
  - [2. User Validation](#2-user-validation)
  - [3. Get All Users](#3-get-all-users)
  - [4. Delete User by Email](#4-delete-user-by-email)

## Prerequisites

- Java 11 or higher
- Maven
- Postman (for API testing)

## Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/your-repository.git
   cd your-repository
   ```

2. Update the database configuration in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=password
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
   spring.h2.console.enabled=true
   ```

3. Build the project using Maven:
   ```bash
   mvn clean install
   ```

## Running the Application

Run the application using Maven:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

## Testing the APIs

### 1. User Registration

**Endpoint**: `POST /api/users/register`

**Request Body**:
```json
{
    "name": "John Doe",
    "email": "john.doe@example.com",
    "gender": "Male",
    "password": "password123"
}
```

**Description**: Registers a new user with the provided details. Ensures that the email is unique.

### 2. User Validation

**Endpoint**: `POST /api/users/validate`

**Request Body**:
```json
{
    "email": "john.doe@example.com",
    "password": "password123"
}
```

**Description**: Validates a user by checking the provided email and password.

### 3. Get All Users

**Endpoint**: `GET /api/users`

**Description**: Retrieves a list of all registered users.

### 4. Delete User by Email

**Endpoint**: `DELETE /api/users/deleteuser`

**Request Body**:
```json
{
    "email": "john.doe@example.com"
}
```

**Description**: Deletes a user based on the provided email.

## Example Postman Requests

1. **User Registration**:
   - Method: POST
   - URL: `http://localhost:8080/api/users/register`
   - Body: raw, JSON
   - Example JSON:
     ```json
     {
         "name": "Jane Smith",
         "email": "jane.smith@example.com",
         "gender": "Female",
         "password": "password456"
     }
     ```

2. **User Validation**:
   - Method: POST
   - URL: `http://localhost:8080/api/users/validate`
   - Body: raw, JSON
   - Example JSON:
     ```json
     {
         "email": "jane.smith@example.com",
         "password": "password456"
     }
     ```

3. **Get All Users**:
   - Method: GET
   - URL: `http://localhost:8080/api/users`

4. **Delete User by Email**:
   - Method: DELETE
   - URL: `http://localhost:8080/api/users/deleteuser`
   - Body: raw, JSON
   - Example JSON:
     ```json
     {
         "email": "jane.smith@example.com"
     }
     ```

## Additional Notes

- The application uses an in-memory H2 database for simplicity. For production use, consider configuring a more robust database such as MySQL or PostgreSQL.
- Ensure you handle exceptions and errors gracefully in a real-world application.
- The current setup is for development purposes only. Update security configurations and other settings as needed for production.

---

This README provides a comprehensive guide to set up, run, and test the CRUD application using Java and Spring Boot.
