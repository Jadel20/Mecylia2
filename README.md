## Description of the project

This project is a basic e-commerce application that enables users to browse products, add them to a cart, place orders, and manage inventory. 
The main entities include User, Role, Customer, Cart, Item and order with a relational setup managed through Spring Data JPA and stored in a MySQL database.
The application follows a layered architecture with a clear separation between service, repository, and controller layers, implementing essential e-commerce functionalities such as cart management and order processing.

## Class diagram

This class diagram illustrates the main entities and relationships:

 -User: Represents the application's authenticated users with roles (USER or ADMIN).

 -Role: Holds user role information (many-to-many relationship with User).

 -Customer: Represents a customer entity.(one-to-many relationship with the saleOrder)

 -Cart: Stores items selected by a user for potential purchase.

 -Item: Represents individual clothing items available for purchase.(many-to-many relationship with the Cart and Order)

 -SalesOrder: Contains details about completed purchases.
 

![UML (Mecylia) - Page 1 (2)](https://github.com/user-attachments/assets/8464bfd7-3adc-46b3-8af6-864a088038b1)


## SET UP

Repository : https://github.com/Jadel20/Mecylia2.git

## Technologies used
- Java
- Spring Boot (Data JPA)
- Maven (dependency management)

## Controller and routes structure

1- CustomerController
- GET api/customer/{id}: Fetch a customer by ID.
- POST api/customer: Create a new customer.
- PUT api/customer/{id}: Update customer details by ID

2- ItemController
- GET api/items: List all items.
- POST api/items: Add a new item.
- PUT api/items/{id} :Update an item by ID
- DELETE api/items/{id}: Delete an item by ID

3-CartController
- GET /carts : Get all the carts
- DELETE /carts/{id} : Delete cart by ID
  
4- SalesOrderController
- GET /orders: Get all the sale orders
- GET /orders/{id}: Get specific sale order by ID
- PUT /orders: Get

## Extra links
Presentation slides : https://docs.google.com/presentation/d/1PzPSWukbC6hD0nBRIas9slxpuFYBMfumE-AL7aBYREI/edit#slide=id.p

## Future work
- Payment integration: Integrate with a payment gateway for order payment.
- Inventory management : Add stock management and item availability features for Admin users.
- User interface : work on front end development.

## Ressources 
- Ironhack student portal 



