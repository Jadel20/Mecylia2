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
 
![UML (Mecylia) - Page 1](https://github.com/user-attachments/assets/89ad9387-edd4-46e8-9a80-0c84d317057b)

## SET UP

Repository :

## Technologies used
- Java
- Spring Boot (Data JPA)
- Maven (dependency management)

## Controller and routes structure



## Extra links
Presentation slides :

## Future work
- Payment integration: Integrate with a payment gateway for order payment.
- Inventory management : Add stock management and item availability features for Admin users.
- User interface : work on front end development.

## Ressources 
- Ironhack student portal 



