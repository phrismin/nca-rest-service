#REST application.

REST application that provides REST API.


##Database configuration.

- Create database nca_users_db. 
- Predefined username - root, predefined password - mysql.
- Change in properties if required.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nca_users_db - database name
spring.datasource.username=root - username
spring.datasource.password=mysql - password
spring.jpa.database=mysql - default database
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect - dialect
spring.jpa.properties.hibernate.format=true - show SQL queries
server.error.include-message=always - include exception messages in JSON
```

##REST requests:

```sh
GET: localhost:9966/api/v1/users/ - get all customers.
GET: localhost:9966/api/v1/users/1 - get customer with ID 1.

POST: localhost:9966/api/v1/users/ - save new user.
Request body: 
{ "name": "Alex", "surname": "Maslaev", "patronymic": "Vasilevich", "age": "55",  "email": "alexvasylevich@gmail.com" }

PUT: localhost:9966/api/v1/users/1 - change user by ID 1.
Request body: 
{ "name": "Alex", "surname": "Maslaev", "patronymic": "Vasilevich", "age": "41",  "email": "anotherEmail@gmail.com" }

DELETE: localhost:9966/api/v1/users/2 - delete user by ID 2.
```