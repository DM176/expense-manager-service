# Expense Sharing Service

A Spring Boot-based REST API service for managing and sharing expenses among users. This application provides a comprehensive solution for tracking expenses, categorizing them, and managing user accounts.

## 🚀 Features

- **Expense Management**: Create, read, update, and delete expenses
- **Category Management**: Organize expenses by categories
- **Account Management**: Manage user accounts and profiles
- **RESTful API**: Full CRUD operations for all entities
- **Security**: JWT-based authentication and authorization
- **Database**: H2 in-memory database with JPA/Hibernate
- **Swagger Documentation**: API documentation (when configured)

## 🛠️ Technology Stack

- **Framework**: Spring Boot 3.1.3
- **Language**: Java 17
- **Database**: H2 Database (in-memory)
- **ORM**: Spring Data JPA with Hibernate
- **Security**: Spring Security with JWT
- **Build Tool**: Maven
- **Lombok**: For reducing boilerplate code
- **Thymeleaf**: Server-side templating (optional)

## 📋 Prerequisites

- Java 17 or higher
- Maven 3.6+
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone <repository-url>
cd expense-manager-service/expensesharing
```

### 2. Build the Project

```bash
mvn clean install
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8015`

### 4. Access H2 Database Console

- URL: `http://localhost:8015/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (leave empty)

## 📊 Data Models

### Expense
- `expenseId` (Long): Primary key
- `expenseName` (String): Name of the expense
- `exepenseDescription` (String): Description of the expense
- `expenseAmount` (BigDecimal): Amount of the expense
- `expenseDate` (Date): Date of the expense
- `account` (Account): Associated account
- `expenseCategory` (Category): Expense category

### Account
- `accountId` (Long): Primary key
- `accountName` (String): Name of the account
- `accountDescription` (String): Description of the account

### Category
- `categoryId` (Long): Primary key
- `categoryName` (String): Name of the category

## 🔌 API Endpoints

### Expenses

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/expenses/` | Get all expenses |
| POST | `/expenses/` | Create a new expense |
| GET | `/expenses/{id}/` | Get expense by ID |
| PUT | `/expenses/{id}/` | Update expense by ID |
| DELETE | `/expenses/{id}/` | Delete expense by ID |

### Categories

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/categories/` | Get all categories |
| POST | `/categories/` | Create a new category |
| GET | `/categories/{id}/` | Get category by ID |
| PUT | `/categories/{id}/` | Update category by ID |
| DELETE | `/categories/{id}/` | Delete category by ID |

### Accounts

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/accounts/` | Get all accounts |
| POST | `/accounts/` | Create a new account |
| GET | `/accounts/{id}/` | Get account by ID |
| PUT | `/accounts/{id}/` | Update account by ID |
| DELETE | `/accounts/{id}/` | Delete account by ID |

## 📝 API Usage Examples

### Create an Expense

```bash
curl -X POST http://localhost:8015/expenses/ \
  -H "Content-Type: application/json" \
  -d '{
    "expenseName": "Lunch",
    "exepenseDescription": "Team lunch at restaurant",
    "expenseAmount": 25.50,
    "expenseDate": "2024-01-15",
    "account": {
      "accountId": 1
    },
    "expenseCategory": {
      "categoryId": 1
    }
  }'
```

### Get All Expenses

```bash
curl -X GET http://localhost:8015/expenses/
```

### Create a Category

```bash
curl -X POST http://localhost:8015/categories/ \
  -H "Content-Type: application/json" \
  -d '{
    "categoryName": "Food & Dining"
  }'
```

### Create an Account

```bash
curl -X POST http://localhost:8015/accounts/ \
  -H "Content-Type: application/json" \
  -d '{
    "accountName": "John Doe",
    "accountDescription": "Personal account"
  }'
```

## 🔧 Configuration

The application configuration is in `src/main/resources/application.properties`:

```properties
# Server Configuration
server.port=8015

# H2 Database Configuration
spring.h2.console.enabled=true

# Development Tools
spring.devtools.restart.enabled=false
```

## 🏗️ Project Structure

```
src/main/java/com/example/expensesharing/expensesharing/
├── authentication/          # Security configurations
├── controller/             # REST controllers
├── dto/                   # Data transfer objects (entities)
├── repository/            # Data access layer
├── service/               # Business logic layer
└── ExpensesharingApplication.java
```

## 🔒 Security

The application includes:
- Spring Security configuration
- JWT authentication support
- OAuth2 resource server
- Basic authentication (configurable)

## 🧪 Testing

Run tests using Maven:

```bash
mvn test
```

## 📦 Dependencies

Key dependencies include:
- `spring-boot-starter-web`: Web application support
- `spring-boot-starter-data-jpa`: JPA data access
- `spring-boot-starter-security`: Security framework
- `spring-boot-starter-oauth2-resource-server`: OAuth2 support
- `h2database`: In-memory database
- `lombok`: Reduces boilerplate code
- `spring-boot-starter-thymeleaf`: Template engine

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🆘 Support

If you encounter any issues or have questions, please:
1. Check the existing issues
2. Create a new issue with detailed information
3. Contact the development team

## 🔄 Future Enhancements

- User authentication and authorization
- Expense sharing between multiple users
- Reporting and analytics
- Mobile application support
- Integration with payment gateways
- Export functionality (PDF, Excel)
- Real-time notifications 