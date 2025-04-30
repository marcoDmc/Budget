# Budget Management API

## Overview

A comprehensive financial management API developed with Java and Spring Boot that enables users to effectively manage their personal finances. This RESTful API provides a robust backend for tracking, categorizing, and analyzing personal expenses and income, supporting both web and mobile client applications.

## Features

- **User Management**: Secure registration and authentication system
- **Account Management**: Create and manage multiple financial accounts
- **Transaction Tracking**: Record and categorize income and expenses
- **Budget Planning**: Set and monitor budget goals for different categories
- **Financial Reports**: Generate insightful reports and visualizations
- **History Logging**: Track changes and activities for accountability

## Technical Stack

- **Backend**: Java 17, Spring Boot, Spring Security, Spring Data JPA
- **Database**: PostgreSQL
- **Authentication**: JWT-based authentication
- **Documentation**: OpenAPI/Swagger
- **Testing**: JUnit, Mockito

## API Endpoints

### Authentication
- `POST /v1/auth/register` - Register a new user
- `POST /v1/auth/login` - Authenticate user and receive token

### User Management
- `POST /v1/user/create` - Create a new user
- `GET /v1/user/{id}` - Get user information
- `PUT /v1/user/{id}` - Update user information
- `DELETE /v1/user/{id}` - Delete user account

### Account Management
- `POST /v1/accounts` - Create a new financial account
- `GET /v1/accounts` - List all user accounts
- `GET /v1/accounts/{id}` - Get specific account details
- `PUT /v1/accounts/{id}` - Update account information
- `DELETE /v1/accounts/{id}` - Delete an account

### Transactions
- `POST /v1/transactions` - Record new transaction
- `GET /v1/transactions` - List all transactions (with filtering options)
- `GET /v1/transactions/{id}` - Get transaction details
- `PUT /v1/transactions/{id}` - Update transaction
- `DELETE /v1/transactions/{id}` - Delete transaction

### Categories
- `POST /v1/categories` - Create new category
- `GET /v1/categories` - List all categories
- `PUT /v1/categories/{id}` - Update category
- `DELETE /v1/categories/{id}` - Delete category

### Budgets
- `POST /v1/budgets` - Create budget plan
- `GET /v1/budgets` - List all budgets
- `GET /v1/budgets/{id}` - Get budget details
- `PUT /v1/budgets/{id}` - Update budget
- `DELETE /v1/budgets/{id}` - Delete budget

### Reports
- `GET /v1/reports/summary` - Get overall financial summary
- `GET /v1/reports/monthly` - Get monthly expense breakdown
- `GET /v1/reports/category` - Get expenses by category
- `GET /v1/reports/trends` - Get spending trends over time

## Data Models

### User
```json
{
  "id": 1,
  "username": "johndoe",
  "email": "johndoe@example.com",
  "createdAt": "2023-04-30T10:30:00",
  "updatedAt": "2023-04-30T10:30:00"
}
```

### Account
```json
{
  "id": 1,
  "name": "Checking Account",
  "balance": 2500.75,
  "currency": "USD",
  "type": "CHECKING",
  "userId": 1,
  "createdAt": "2023-04-30T10:35:00",
  "updatedAt": "2023-04-30T10:35:00"
}
```

### Transaction
```json
{
  "id": 1,
  "amount": 125.50,
  "type": "EXPENSE",
  "description": "Grocery shopping",
  "date": "2023-04-29T15:45:00",
  "categoryId": 3,
  "accountId": 1,
  "userId": 1,
  "createdAt": "2023-04-29T15:50:00"
}
```

### Category
```json
{
  "id": 3,
  "name": "Groceries",
  "type": "EXPENSE",
  "color": "#4CAF50",
  "icon": "shopping_cart",
  "userId": 1
}
```

## Security

The API implements comprehensive security measures:
- JWT-based authentication
- Password encryption
- Role-based access control
- HTTPS/TLS for all communications
- Input validation and protection against common attacks

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- PostgreSQL 12+

### Installation
1. Clone the repository
2. Configure database connection in `application.properties`
3. Run `mvn clean install`
4. Start the application with `mvn spring-boot:run`
5. Access the API documentation at `http://localhost:8080/swagger-ui.html`

## Development

### Environment Setup
```properties
# application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/budget_db
spring.datasource.username=postgres
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

### Running Tests
```bash
mvn test
```

## License

This project is licensed under the MIT License - see the LICENSE file for details.