# Swifty E-Commerce Backend API

Welcome to the Swifty E-Commerce Backend API! This API powers the backend functionality of our e-commerce application, allowing seamless management of products and orders.

<!-- ## Table of Contents
- [Project Overview](#project-overview)
- [Functional Requirements](#functional-requirements)
  - [1. Product Management](#1-product-management)
  - [2. Order Management](#2-order-management)
- [Technical Requirements](#technical-requirements)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [API Endpoints](#api-endpoints)
  - [1. Product Management](#1-product-management)
  - [2. Order Management](#2-order-management)
- [Error Handling](#error-handling)
- [Database Schema](#database-schema)
- [Documentation](#documentation)
- [Contributing](#contributing)
- [License](#license) -->

## Project Overview

The Swifty E-Commerce Backend API is built using Spring Boot and facilitates the core functionalities of our e-commerce platform. It includes features for product management and order processing.

## Functional Requirements

### 1. Product Management

#### 1.1 Create a Product

- **Endpoint:** `POST /api/products`
- **Request Payload:**
  ```json
  {
  	"name": "Product Name",
  	"description": "Product Description",
  	"price": 29.99,
  	"stockQuantity": 100
  }
  ```
- **Response Payload:**
  ```json
  {
  	"id": 1,
  	"name": "Product Name",
  	"description": "Product Description",
  	"price": 29.99,
  	"stockQuantity": 100
  }
  ```
- **Description:** Creates a new product with the given name, description, price, and stock quantity.
- **Error Handling:** Returns a `400 Bad Request` error if the request payload is invalid.
- **Database Operation:** Inserts a new product into the database.
<!-- - **Security:** Requires a valid JWT token with the `ROLE_ADMIN` role. -->

#### 1.2 Get All Products

- **Endpoint:** `GET /api/products`
- **Response Payload:**
  ```json
  [
  	{
  		"id": 1,
  		"name": "Product Name",
  		"description": "Product Description",
  		"price": 29.99,
  		"stockQuantity": 100
  	},
  	{
  		"id": 2,
  		"name": "Product Name",
  		"description": "Product Description",
  		"price": 29.99,
  		"stockQuantity": 100
  	}
  ]
  ```
- **Description:** Returns a list of all products.
- **Error Handling:** Returns a `500 Internal Server Error` error if the database operation fails.
- **Database Operation:** Retrieves all products from the database.
<!-- - **Security:** Requires a valid JWT token with the `ROLE_ADMIN` role. -->

#### 1.3 Get a Product

- **Endpoint:** `GET /api/products/{id}`
- **Response Payload:**
  ```json
  {
  	"id": 1,
  	"name": "Product Name",
  	"description": "Product Description",
  	"price": 29.99,
  	"stockQuantity": 100
  }
  ```
- **Description:** Returns the product with the given ID.
- **Error Handling:** Returns a `404 Not Found` error if the product with the given ID does not exist.
- **Database Operation:** Retrieves the product with the given ID from the database.
<!-- - **Security:** Requires a valid JWT token with the `ROLE_ADMIN` role. -->

#### 1.4 Update a Product

- **Endpoint:** `PUT /api/products/{id}`
- **Request Payload:**
  ```json
  {
  	"name": "Product Name",
  	"description": "Product Description",
  	"price": 29.99,
  	"stockQuantity": 100
  }
  ```
- **Response Payload:**
  ```json
  {
  	"id": 1,
  	"name": "Product Name",
  	"description": "Product Description",
  	"price": 29.99,
  	"stockQuantity": 100
  }
  ```
- **Description:** Updates the product with the given ID.
- **Error Handling:** Returns a `400 Bad Request` error if the request payload is invalid. Returns a `404 Not Found` error if the product with the given ID does not exist.
- **Database Operation:** Updates the product with the given ID in the database.
<!-- - **Security:** Requires a valid JWT token with the `ROLE_ADMIN` role. -->

#### 1.5 Delete a Product

- **Endpoint:** `DELETE /api/products/{id}`
- **Description:** Deletes the product with the given ID.
- **Error Handling:** Returns a `404 Not Found` error if the product with the given ID does not exist.
- **Database Operation:** Deletes the product with the given ID from the database.
<!-- - **Security:** Requires a valid JWT token with the `ROLE_ADMIN` role. -->
- 
### 2. Order Management

#### 2.1 Create an Order

- **Endpoint:** `POST /api/orders`
- **Request Payload:**
  ```json
  {
  	"products": [
  		{
  			"id": 1,
  			"quantity": 2
  		},
  		{
  			"id": 2,
  			"quantity": 1
  		}
  	]
  }
  ```
- **Response Payload:**
  ```json
  {
  	"id": 1,
  	"products": [
  		{
  			"id": 1,
  			"name": "Product Name",
  			"description": "Product Description",
  			"price": 29.99,
  			"stockQuantity": 100,
  			"quantity": 2
  		},
  		{
  			"id": 2,
  			"name": "Product Name",
  			"description": "Product Description",
  			"price": 29.99,
  			"stockQuantity": 100,
  			"quantity": 1
  		}
  	],
  	"totalPrice": 89.97
  }
  ```
- **Description:** Creates a new order with the given products.
- **Error Handling:** Returns a `400 Bad Request` error if the request payload is invalid. Returns a `404 Not Found` error if any of the products do not exist. Returns a `409 Conflict` error if any of the products do not have enough stock.

- **Database Operation:** Inserts a new order into the database.
<!-- - **Security:** Requires a valid JWT token with the `ROLE_USER` role. -->

#### 2.2 Get All Orders

- **Endpoint:** `GET /api/orders`
- **Response Payload:**
  ```json
  [
  	{
  		"id": 1,
  		"products": [
  			{
  				"id": 1,
  				"name": "Product Name",
  				"description": "Product Description",
  				"price": 29.99,
  				"stockQuantity": 100,
  				"quantity": 2
  			},
  			{
  				"id": 2,
  				"name": "Product Name",
  				"description": "Product Description",
  				"price": 29.99,
  				"stockQuantity": 100,
  				"quantity": 1
  			}
  		],
  		"totalPrice": 89.97
  	},
  	{
  		"id": 2,
  		"products": [
  			{
  				"id": 1,
  				"name": "Product Name",
  				"description": "Product Description",
  				"price": 29.99,
  				"stockQuantity": 100,
  				"quantity": 2
  			},
  			{
  				"id": 2,
  				"name": "Product Name",
  				"description": "Product Description",
  				"price": 29.99,
  				"stockQuantity": 100,
  				"quantity": 1
  			}
  		],
  		"totalPrice": 89.97
  	}
  ]
  ```
- **Description:** Returns a list of all orders.
- **Error Handling:** Returns a `500 Internal Server Error` error if the database operation fails.
- **Database Operation:** Retrieves all orders from the database.
<!-- - **Security:** Requires a valid JWT token with the `ROLE_ADMIN` role. -->

#### 2.3 Get an Order

- **Endpoint:** `GET /api/orders/{id}`

- **Response Payload:**
  ```json
  {
  	"id": 1,
  	"products": [
  		{
  			"id": 1,
  			"name": "Product Name",
  			"description": "Product Description",
  			"price": 29.99,
  			"stockQuantity": 100,
  			"quantity": 2
  		},
  		{
  			"id": 2,
  			"name": "Product Name",
  			"description": "Product Description",
  			"price": 29.99,
  			"stockQuantity": 100,
  			"quantity": 1
  		}
  	],
  	"totalPrice": 89.97
  }
  ```
- **Description:** Returns the order with the given ID.
- **Error Handling:** Returns a `404 Not Found` error if the order with the given ID does not exist.
- **Database Operation:** Retrieves the order with the given ID from the database.
<!-- - **Security:** Requires a valid JWT token with the `ROLE_ADMIN` role. -->

#### 2.4 Update an Order

- **Endpoint:** `PUT /api/orders/{id}`
- **Request Payload:**
  ```json
  {
  	"products": [
  		{
  			"id": 1,
  			"quantity": 2
  		},
  		{
  			"id": 2,
  			"quantity": 1
  		}
  	]
  }
  ```
- **Response Payload:**
  ```json
  {
  	"id": 1,
  	"products": [
  		{
  			"id": 1,
  			"name": "Product Name",
  			"description": "Product Description",
  			"price": 29.99,
  			"stockQuantity": 100,
  			"quantity": 2
  		},
  		{
  			"id": 2,
  			"name": "Product Name",
  			"description": "Product Description",
  			"price": 29.99,
  			"stockQuantity": 100,
  			"quantity": 1
  		}
  	],
  	"totalPrice": 89.97
  }
  ```
- **Description:** Updates the order with the given ID.
- **Error Handling:** Returns a `400 Bad Request` error if the request payload is invalid. Returns a `404 Not Found` error if the order with the given ID does not exist. Returns a `409 Conflict` error if any of the products do not have enough stock.
- **Database Operation:** Updates the order with the given ID in the database.
<!-- - **Security:** Requires a valid JWT token with the `ROLE_USER` role. -->

#### 2.5 Delete an Order

- **Endpoint:** `DELETE /api/orders/{id}`
- **Description:** Deletes the order with the given ID.

- **Error Handling:** Returns a `404 Not Found` error if the order with the given ID does not exist.
- **Database Operation:** Deletes the order with the given ID from the database.
<!-- - **Security:** Requires a valid JWT token with the `ROLE_ADMIN` role. -->

## Technical Requirements

- [x] The API must be built using Spring Boot.
- [ ] The API must be backed by a MySQL database.
- [ ] The API must be documented using Swagger.
<!-- - [ ] The API must be deployed to Heroku. -->

<!-- ## Getting Started

### Prerequisites

- [Java 17](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/download.cgi)
- [MySQL](https://dev.mysql.com/downloads/mysql/)
- [Heroku CLI](https://devcenter.heroku.com/articles/heroku-cli)
- [Postman](https://www.postman.com/downloads/)
- [Swagger](https://swagger.io/tools/swagger-ui/download/)
 -->
