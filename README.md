# Weather CSV Processing Service

## Project Overview

This project is a Spring Boot REST API that processes weather data from a CSV file, stores the records in an Oracle database, and provides endpoints to retrieve the data with filtering and sorting functionality.

The system reads the provided CSV dataset, converts each row into a weather record, persists it using JPA/Hibernate, and exposes REST endpoints for accessing the stored information.

---

## Technology Stack

* Java 17+
* Spring Boot
* Spring Data JPA (Hibernate)
* Oracle Database
* Maven
* Swagger (OpenAPI)
* Postman for API testing

---

## Setup and Run Instructions

### 1. Clone / Download Project

Extract the project folder and open it in Spring Tool Suite (STS) or any IDE.

---

### 2. Configure Database

Update `application.properties`:

spring.datasource.url=jdbc:oracle:thin:@localhost:1521:XE
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update

Start Oracle database before running the application.

---

### 3. Place CSV File

Put the CSV file in the project root directory:

weather-service/testset.csv

(Or update the file path inside the service accordingly.)

---

### 4. Run the Application

Run:

WeatherServiceApplication.java

The server will start on:

http://localhost:6001

---

### 5. Load CSV Data into Database

Send POST request:

POST http://localhost:6001/weather/load

This reads the CSV and inserts records into the database.

---

## API Details

### Load CSV into Database

POST /weather/load

Loads the CSV file and stores all weather records.

---

### Get All Weather Records

GET /weather

Returns all stored weather data.

---

### Get Sorted Weather Records

GET /weather?sort=temperature

Example fields for sorting:

* temperature
* humidity
* pressure
* windSpeed
* timestamp

---

### Filter Weather Records

Filter by temperature range:

GET /weather/filter?minTemp=20&maxTemp=30

Filter by weather condition:

GET /weather/filter?condition=Haze

Combine filters:

GET /weather/filter?minTemp=20&maxTemp=30&condition=Haze

---

## Swagger Documentation

After running the application, open:

http://localhost:6001/swagger-ui/index.html

You can test all APIs directly from Swagger UI also.
