###Welcome to DigitMarket

###To Skip Description and To Quick easy setup Go to the last section(How to Quick Run )

####################################################################################################################
# Default Digit Market Store Project 

## Introduction  
This is a sample Java 1.8 / Maven / Spring Boot (version 1.5.7.RELEASE) application with Spring Data, microservice REST APIS, web, actuators module with built-in health check, metrics, jUNIT5, swagger integration and much more.

## How to Run 


This application is packaged as a war which has Tomcat 8 embedded. No Tomcat 8 or above  or JBoss installation is necessary. You run it using the ```java -jar``` command.

This application can be packeged with jar/war with very minimal changes and can be run in external or embedded tomcat.


* Clone this repository 
* Make sure you are using JDK 1.8 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service by one of these two methods:
```
        java -jar -Dspring.profiles.active=test target/DigitMarketVendor.war
or
        mvn spring-boot:run -Drun.arguments="spring.profiles.active=test"
```
* Check the stdout or boot_example.log file to make sure no exceptions are thrown

Once the application runs you should see something like this

```
2017-08-30 17:31:23.091  INFO 19387 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8089 (http)
2017-08-30 17:31:23.097  INFO 19387 --- [           main] com.khoubyari.example.Application        : Started Application in 22.285 seconds (JVM running for 23.032)
```

## About the DigitMarket Service

The service is DigitMarket Product service. It uses an MySQL to store the data. You can also do with a non relational database like MongoDB. If your database connection properties work, you can call some REST endpoints defined in ```com.digitmarket.vendor.rest.ProductController``` on **port 8089**. (see below)

More interestingly, you can start calling some of the operational endpoints (see full list below) like ```/metrics``` and ```/health``` (these are available on **port 8091**)

You can use this sample service to understand the conventions and configurations that allow you to create a DB-backed RESTful service. Once you understand and get comfortable with the sample app you can add your own services following the same patterns as the sample service.
 
Here is what this little application demonstrates: 

* Full integration with the latest **Spring** Framework: inversion of control, dependency injection, etc.
* Packaging as a single war with embedded container (tomcat 8): No need to install a container separately on the host just run using the ``java -jar`` command
* Demonstrates how to set up healthcheck, metrics, info, environment, etc. endpoints automatically on a configured port. Inject your own health / metrics info with a few lines of code.
* Writing a RESTful service using annotation: supports both XML and JSON request / response; simply use desired ``Accept`` header in your request
* Exception mapping from application exceptions to the right HTTP response with exception details in the body
* *Spring Data* Integration with JPA/Hibernate with just a few lines of configuration and familiar annotations. 
* Automatic CRUD functionality against the data source using Spring *Repository* pattern
* Demonstrates MockMVC test framework with associated libraries
* All APIs are "self-documented" by Swagger2 using annotations 

Here are some endpoints you can call:

### Get information about system health, configurations, etc.

```
http://localhost:8091/env
http://localhost:8091/health
http://localhost:8091/info
http://localhost:8091/metrics
```

### Create a Product resource

```
POST /example/v1/products
Accept: application/json
Content-Type: application/json

{
"name" : "Beds R Us",
"description" : "Very basic, small rooms but clean",
"city" : "Santa Ana",
"rating" : 2
}

RESPONSE: HTTP 201 (Created)
Location header: http://localhost:8090/example/v1/products/1
```

### Retrieve a paginated list of hotels

```
http://localhost:8090/example/v1/products?page=0&size=10

Response: HTTP 200
Content: paginated list 
```

### Update a hotel resource

```
PUT /example/v1/hotels/1
Accept: application/json
Content-Type: application/json

{
"name" : "Beds R Us",
"description" : "Very basic, small rooms but clean",
"city" : "Santa Ana",
"rating" : 3
}

RESPONSE: HTTP 204 (No Content)
```
### To view Swagger 2 API docs

Run the server and browse to localhost:8089/swagger-ui.html

# About Spring Boot

Spring Boot is an "opinionated" application bootstrapping framework that makes it easy to create new RESTful services (among other types of applications). It provides many of the usual Spring facilities that can be configured easily usually without any XML. In addition to easy set up of Spring Controllers, Spring Data, etc. Spring Boot comes with the Actuator module that gives the application the following endpoints helpful in monitoring and operating the service:

**/metrics** Shows “metrics” information for the current application.

**/health** Shows application health information.

**/info** Displays arbitrary application info.

**/configprops** Displays a collated list of all @ConfigurationProperties.

**/mappings** Displays a collated list of all @RequestMapping paths.

**/beans** Displays a complete list of all the Spring Beans in your application.

**/env** Exposes properties from Spring’s ConfigurableEnvironment.

**/trace** Displays trace information (by default the last few HTTP requests).

### To view your H2 in-memory datbase

The 'test' profile runs on H2 in-memory database. To view and query the database you can browse to http://localhost:8090/h2-console. Default username is 'sa' with a blank password. Make sure you disable this in your production profiles. For more, see https://goo.gl/U8m62X

# Running the project with MySQL

This project uses an in-memory database so that you don't have to install a database in order to run it. However, converting it to run with another relational database such as MySQL or PostgreSQL is very easy. Since the project uses Spring Data and the Repository pattern, it's even fairly easy to back the same service with MongoDB. 

Here is what you would do to back the services with MySQL, for example: 

### In pom.xml add: 

```
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
```

### Append this to the end of application.yml: 

```
---
spring:
  profiles: mysql

  datasource:
    driverClassName: com.mysql.jdbc.Driver
    url: jdbc:mysql://<your_mysql_host_or_ip>/bootexample
    username: <your_mysql_username>
    password: <your_mysql_password>

  jpa:
    hibernate:
      dialect: org.hibernate.dialect.MySQLInnoDBDialect
      ddl-auto: update # todo: in non-dev environments, comment this out:


hotel.service:
  name: 'test profile:'
```

### Then run is using the 'mysql' profile:

```
        java -jar -Dspring.profiles.active=mysql target/spring-boot-rest-example-0.4.0.war
or
        mvn spring-boot:run -Drun.arguments="spring.profiles.active=mysql"
```

# Attaching to the app remotely from your IDE

Run the service with these command line options:

```
mvn spring-boot:run -Drun.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"
or
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -Dspring.profiles.active=test -Ddebug -jar target/spring-boot-rest-example-0.4.0.war
```
and then you can connect to it remotely using your IDE. For example, from IntelliJ You have to add remote debug configuration: Edit configuration -> Remote.

# Questions and Comments: digitmarket@gmail.com



#Spring Boot application properties

##Data source configuration
spring.datasource.url=jdbc:mysql://localhost/digital_vendor_db?autoReconnect=true&useSSL=false
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
####################################################################################################################

## How to Quick Run 

### Set up the Database

 1. Create a database named "digital_vendor_db" in MySQL using MySQL client app like (workbench or other tools etc)
 2. Use respective database user and password. Using root and root for current set up.

## Steps

1. Copy the war i.e (DefaultDigitMarketStore.war) from /target folder of the DefaultDigitMarketStore application

2. Deploy/paste to webapps folder in tomcat 8 or above 

3. Go to the browser and copy the link i.e http://localhost:8089/DigitMarketVendor

4. If we need to change the port then simply go to application.properties file and change the app.port i.e.  app.port=8081

5. Start the tomcat. It will create all neccesaroy tables by reading the jpa entites defiend in the application.

6. To create a test user run the following sql query script can be found in src/main/resources/static/db folder.  i.e "/digital_vendor.dml.sql" using MySql client app.

7. Use below default credential to access the application


### Default User credential

username  : digital@gmail.com
password  : condigence 
