# Getting Started

## Environment Setup
To start this environment, you will need a JDK environment with java 8.

The easiest way to run this project is to run the following command:
$ ./mvnw clean && mvnw install && java -jar target/socin-0.0.1-SNAPSHOT.jar

In this command runs maven and starts an instance of the application.

## Database
The database is made in mysql. Default settings can be changed in the
application.properties file.

## Frontend
Temporarily, the frontend application was developed in bootstrap.
When going up in a local environment, change the base annotation in "menu.jsp":
[const apiUrl = 'https://socin.herokuapp.com']

### Test application
There is a dedicated test environment for the application, to access it:
https://socin.herokuapp.com/web/login
The default username and password are: 'lauren@test.com' and '123456'.