# Crypto Market Data Pipeline

A Spring Boot backend service that ingests cryptocurrency candlestick market data from the Binance API, stores normalized records in a relational database, and exposes REST APIs for loading and querying market data.

This project demonstrates backend API design, service-layer architecture, external API integration, database persistence with MyBatis, parallel data loading, and AOP-based logging.

## Features

- Ingests 1-minute cryptocurrency candlestick data from the Binance API
- Splits large time ranges into smaller request windows for batch loading
- Uses Java parallel streams to improve data ingestion throughput
- Stores normalized candlestick records in MySQL / AWS RDS
- Provides REST endpoints for loading and querying market data
- Uses MyBatis for SQL mapping and database access
- Implements service, repository, controller, and model layers
- Adds AOP-based logging for better observability and debugging

## Tech Stack

**Backend**

- Java
- Spring Boot
- Spring MVC
- Spring AOP
- MyBatis

**Database**

- MySQL
- AWS RDS

**Tools**

- Maven
- JUnit
- Git

## Architecture

```text
Client / API Tester
  ↓
Spring Boot REST Controller
  ↓
Service Layer
  ↓
Binance API Data Source
  ↓
Data Transformation / Aggregation
  ↓
MyBatis Repository
  ↓
MySQL / AWS RDS
```

## Project Structure

```text
crypto-market-data-pipeline/
  src/
    main/
      java/
        com/roger/crypto/
          CryptoDataPipelineApplication.java
          LogAspect.java

          configuration/
            AppConfiguration.java

          controller/
            CandlestickController.java
            GetDataController.java

          model/
            Candlestick.java

          repository/
            CandlestickMyBatisRepository.java

          service/
            BinanceSourceServiceImpl.java
            CandlestickService.java
            DataSourceService.java
            Refactor.java

      resources/
        application-example.properties

    test/
      java/
        com/roger/crypto/
          ServiceTest/
          controllerTest/
          modelTest/
          repository/
```

## Core Implementation Details

### Data Ingestion

The service loads candlestick data by splitting a large time range into smaller request windows. Each request retrieves a limited batch of candlestick records from the Binance API and inserts the results into the database.

### Parallel Processing

The ingestion workflow uses Java parallel streams to process multiple time windows concurrently, improving throughput when loading large historical data ranges.

### Database Persistence

The project uses MyBatis to map Java objects to SQL operations and persist candlestick data into a relational database.

### AOP Logging

Spring AOP is used to separate logging concerns from business logic, improving maintainability and making service execution easier to observe during development and debugging.

## Configuration

The real `application.properties` file is ignored by Git to avoid exposing database credentials.

Use the provided example file:

```text
src/main/resources/application-example.properties
```

Create your own local configuration file:

```text
src/main/resources/application.properties
```

Example configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/crypto_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=your_username
spring.datasource.password=your_password

mybatis.configuration.map-underscore-to-camel-case=true

binance.api.kline-url=https://www.binance.com/api/v1/klines?symbol=%s&interval=1m&startTime=%d&endTime=%d&limit=%d
```

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/rogerthedager/crypto-market-data-pipeline.git
cd crypto-market-data-pipeline
```

### 2. Configure the database

Create a MySQL database:

```sql
CREATE DATABASE crypto_db;
```

Then update your local `application.properties` with your database URL, username, and password.

### 3. Build the project

Using Maven:

```bash
mvn clean package
```

Or using the Maven wrapper:

```bash
./mvnw clean package
```

On Windows:

```bash
mvnw.cmd clean package
```

### 4. Run the application

Using Maven:

```bash
mvn spring-boot:run
```

Or with the Maven wrapper:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

The backend runs by default on:

```text
http://localhost:8080
```

## API Endpoints

### Load Candlestick Data

```http
POST /load
```

Loads candlestick market data for a given symbol and time range.

Example request parameters:

```text
symbol=BTCUSDT
startTime=START_TIMESTAMP
endTime=END_TIMESTAMP
```

### Query Candlestick Data

```http
GET /candlestick
```

Retrieves candlestick data from the database based on symbol and time range.

Example request parameters:

```text
symbol=BTCUSDT
startTime=START_TIMESTAMP
endTime=END_TIMESTAMP
interval=5
```

## Testing

The project includes unit and integration-style tests for service, controller, model, and repository layers.

Run tests with:

```bash
mvn test
```

Or:

```bash
./mvnw test
```

## What I Learned

- Designed a layered Spring Boot backend application
- Integrated an external market data API into a backend service
- Used MyBatis for SQL mapping and database persistence
- Improved ingestion throughput with Java parallel streams
- Applied Spring AOP for logging and separation of concerns
- Practiced backend testing across controller, service, model, and repository layers

## Future Improvements

- Add Redis-based distributed locking to prevent duplicate ingestion jobs
- Add scheduled ingestion using Spring Scheduler or AWS EventBridge
- Add Docker support for local MySQL and application startup
- Add API documentation with Swagger / OpenAPI
- Add pagination and input validation for query endpoints
