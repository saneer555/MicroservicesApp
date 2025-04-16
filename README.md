MicroservicesApp
├── user-service        # Handles user management
├── product-service     # Handles product management
└── order-service       # Manages order creation

Setup and Installation
Prerequisites
Java 17 or higher

Maven

MySQL or H2 database (configured in application.properties for local setup)

Spring Boot dependencies
*****************************************************************************************************************
git clone https://github.com/saneer555/MicroservicesApp.git
cd MicroservicesApp
Running the Application
User Service:

Start the User Service at port 8081.

Product Service:

Start the Product Service at port 8082.

Order Service:

Start the Order Service at port 8083.

Build the project
Run the following Maven command to build the project:

bash
Copy
Edit
mvn clean install
Running with Spring Boot
To run each service, navigate to the service directory and use:

bash
Copy
Edit
mvn spring-boot:run
***********************************************************************************************************
You can also run the entire application using Docker Compose if preferred.

API Endpoints
User Service (Port: 8081)
Create User:

POST /api/users

Request Body:

json
Copy
Edit
{
  "name": "John Doe",
  "email": "john@example.com"
}
Get All Users:

GET /api/users

Get User by ID:

GET /api/users/{id}

Update User:

PUT /api/users/{id}

Request Body: Same as Create User

Delete User:

DELETE /api/users/{id}
*******************************************************************************************************
Product Service (Port: 8082)
Create Product:

POST /api/products

Request Body:

json
Copy
Edit
{
  "name": "Laptop",
  "price": 999.99
}
Get All Products:

GET /api/products

Get Product by ID:

GET /api/products/{id}

Update Product:

PUT /api/products/{id}

Request Body: Same as Create Product

Delete Product:

DELETE /api/products/{id}
*********************************************************************************************************8
Order Service (Port: 8083)
Create Order:

POST /api/orders

Request Body:

json
Copy
Edit
{
  "userId": 1,
  "productId": 1,
  "quantity": 2
}

Testing
You can test the API endpoints using Postman or cURL.
***************************************************************************************************
Example cURL Commands
Create User:


curl -X POST -H "Content-Type: application/json" -d '{"name":"John Doe","email":"john@example.com"}' http://localhost:8081/api/users
Create Product:


curl -X POST -H "Content-Type: application/json" -d '{"name":"Laptop","price":999.99}' http://localhost:8082/api/products
Create Order:

curl -X POST -H "Content-Type: application/json" -d '{"userId":1,"productId":1,"quantity":2}' htt
