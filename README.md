# Bookstore-Management

## Overview
The Bookstore Management System is a web application designed to help manage books, authors. It is built using:
- Spring Boot: For the backend RESTful API.
- React JS: For the frontend user interface.
- PostgreSQL: For the relational database management.
- Docker: To containerize the PostgreSQL database.

## Database Schema
The PostgreSQL database includes the following tables:

### Authors Table
- id: Integer, Primary Key, Auto-increment.
- name: String, Name of the author.
- age: Integer, Age of the author.
- description: String, Description of the author.
- image: String, It contains url of the image of the author.

### Books Table
- isbn: String, International Standard Book Number.
- title: String, Title of the book.
- description: String, Description of the book.
- image: String, It contains the url of the image of the book.
- author_id: Integer, Foreign Key, References id in the authors table.

## Relationships
- Many-to-One: Each book is associated with one author, but an author can write multiple books.

## Prerequisites
Ensure you have the following tools installed:

- Docker
- Docker Compose
- Java 17 (for Spring Boot)
- Node.js (for React JS)
- PostgreSQL client (optional, for direct database access)

## Getting Started

### 1. Clone the Repository

``` bash
git clone https://github.com/sainiharshit322/bookstore-management.git
cd bookstore-management
```

### 2. Set Up the Database
The PostgreSQL database is managed using Docker. To start the database:

1. Navigate to the docker directory:

``` bash
cd docker
```

2. Start the PostgreSQL container:

``` bash
docker-compose up -d
```
This command runs the PostgreSQL database in detached mode.

### 3. Configure the Backend

1. Navigate to the backend directory:

``` bash
cd ../backend
```

2. Set up environment variables:

Create a .env file in the backend directory with the following content:

``` bash
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/bookstore
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=password
```

3. Build and run the Spring Boot application:

``` bash
./mvnw spring-boot:run
```

### 4. Set Up the Frontend

1. Navigate to the frontend directory:

``` bash
cd ../frontend
```

2. Install dependencies:

``` bash
npm install
```

3. Start the React application:

``` bash
npm start
```
The React application will be accessible at http://localhost:3000.

## Configuration

- Backend: Configuration settings are in src/main/resources/application.properties or can be overridden using environment variables.
- Frontend: Update src/config/apiConfig.js to set the API base URL if necessary.

## Testing
- Backend Tests: Run tests with Maven:

``` bash
./mvnw test
```

- Frontend Tests: Run tests with npm:

``` bash
npm test
```

## Deployment
For deployment, you can create Dockerfiles for both frontend and backend, and use Docker Compose to manage the multi-container setup.

## Troubleshooting

- Database Connection Issues: Verify Docker is running and the PostgreSQL container is up. Ensure database credentials in the .env file are correct.
- Frontend Issues: Ensure the backend server is running and accessible. Use browser developer tools to check network requests.

## Contributing
Contributions are welcome! Please fork the repository and submit a pull request with your changes.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact
For any inquiries or issues, please contact sainiharshit322@gmail.com.
