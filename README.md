# Demo Microservice Example:  Cart Service

This is a simple web / REST app that serves as a shopping cart.  You can create carts, add items to carts, etc..

GET  /carts/{customer} - Returns a list of all items in a cart for a customer
POST /carts/{customer} - Add a new item to a customer's cart
PUT  /carts/{customer}/items/{code} - Update item in a customer's cart
DELETE /carts/{customer} - Remove a customer's cart

The shopping cart contents at the start of the demo:

Customer 111 has 2 items in their cart, AAA and BBB
Customer 222 has 3 items in their cart, CCC, DDD, and EEE
Customer 333 has 2 items in their card, DDD and EEE


This code also demonstrates:
- Basic usage of Spring Boot
- Spring Cloud is included, but not really used.
- Spring Cloud AWS is included, but not really used.
- Embedded HSQLDB Database, prepopulated with test data.
- Spring Data JPA.
- Runs nicely on or off AWS.
- Actuator endpoints are present.
