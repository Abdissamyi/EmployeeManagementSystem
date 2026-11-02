# Employee Management System

A Java-based Employee Management System built using JDBC and Oracle Database.

## Technologies Used
- Java 25
- JDBC
- Oracle Database 21c XE
- Maven
- IntelliJ IDEA

## Architecture

The application follows a layered architecture:

- **Model:** Represents employee entities.
- **DAO:** Handles database operations.
- **Service:** Implements business logic and validation.
- **Main:** Runs the application.

## Features

- Add employees
- Retrieve employees by ID
- Update employee salaries
- Delete employees
- Validate employee data
- Connect to Oracle Database using JDBC

## Database Configuration

Configure the following environment variables before running the application:

| Variable | Description |
|---|---|
| `DB_USER` | Oracle database username |
| `DB_PASSWORD` | Oracle database password |

Database URL: `jdbc:oracle:thin:@localhost:1521/XEPDB1`

## Run the Project

1. Clone this repository.
2. Open it in IntelliJ IDEA.
3. Configure the Oracle database credentials.
4. Reload Maven dependencies.
5. Run `Main.java`.

**Note:** An Oracle Database instance with the HR schema is required.