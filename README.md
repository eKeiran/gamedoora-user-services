# gamedoora-user-services

The Spring boot microservice application for gamedoora

## Requirements
- JDK 17
- MySql 5 or higher
- Maven 3.3 or higher 

## Command to build and launch
```
mvnw clean install
```
```
mvnw spring-boot:run 
```

## For setting local firebase environment 
https://firebase.google.com/codelabs/firebase-emulator#1

## Service dependencies
1. Gamedoora Config Service  
   a. Run the config server  
   b. Set CONFIG_SERVER to the URL of the config server
      ```
      export CONFIG_SERVER=<URL of the config server>
      ``` 

