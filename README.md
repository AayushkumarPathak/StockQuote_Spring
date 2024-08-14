# Stock Quote Application

## Overview
The Stock Quote application is a Spring Boot application that provides stock quotes through a RESTful API. It uses Spring Security for authentication.

## Prerequisites
- Java 11 or higher
- Maven
- An API key from Alpha Vantage (obtain it [here](https://www.alphavantage.co/support/#api-key))

## Getting Started

### Clone the Repository
```bash
git clone <repository-url>
cd stock-quote

## Spring Security
The application uses Spring Security for basic authentication. Use the following credentials to access the API:

Username: admin
Password: admin

Testing the API
### Get Quote for a Single Stock
GET http://localhost:8020/api/stocks/quote/{symbol}
### Get Quotes for Multiple Stocks
GET http://localhost:8020/api/stocks/quotes?symbols=AAPL,MSFT,GOOGL

Notes
Ensure the application is running on port 8020.
Make sure to include your Alpha Vantage API key in the application properties for successful API calls.




