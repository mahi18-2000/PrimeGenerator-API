# Prime Generator API
This is a simple API build using spring-boot (Java-based framework) and H2 Database.
You can use this to generate prime numbers within a given range as per user request.  

## How to Run
   This application use Maven to manage its dependencies. So, make sure that you are using JDK 1.8 and have installed Maven 3.x  
   If you have not installed Maven yet, refer to the below link. 
        
   https://maven.apache.org/download.cgi
      
   From here, download ``` apache-maven-3.8.4-bin.zip ```
   * Clone this repository
   * You can launch the application, either right-click the public static void main in ServerMain and select Run from your IDE, or:  
   	``` $ mvn clean spring-boot:run
   	```
   
   Check the stdout or console to make sure no exceptions are thrown.
   
   Once the application runs you should see something like this
   ```
   2022-01-24 20:33:23.573  INFO 12868 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
   2022-01-24 20:33:23.583  INFO 12868 --- [           main] PrimeGenerator.ServerMain                : Started ServerMain in 3.814 seconds (JVM running for 4.185)
   ```
    
##   About the Service
   The service is a simple prime-generator REST service. It uses an in-memory database (H2) to store the data.
   
###   Generate Prime numbers

   ```curl 
    $ curl -X POST localhost:8080/primes -H 'Content-type:application/json' -d '{"userId" : "exampleUser","rangeStart" : 1,"rangeEnd" : 20,"algorithm" : "SIEVE"}'
   ```
     
     
   |Field|Description|
   |:---:|:---:|
   |userId|Provide your userId|
   |rangeStart|The lower limit of the range|
   |rangeEnd|The upper limit of the range|
   |algorithm|The algorithm which you want to use for generating prime numbers|

   ``` Note: ```If you are using Windows Command Prompt to issue cURL commands, chances are the above command won’t work properly. You must either pick a terminal that support single quoted arguments, or use double quotes and then escape the ones inside the JSON or either you can use ``` Postman``` to post a request.
      
   
###   Retrieve all the User logs 
```
            https://localhost:8080/service-logs
  or
            $ curl -v localhost:8080/service-logs 
```
   This will send you the logs of the users in JSON format.
     
   Here is what the log contains:
   
   |Field|Description|
   |:---:|:---|
   |requestId|  A unique request id generated when a user sends a post request to our API.|
   |userId |  id used by the user while posting the request.|
   |range | range given by the user for generating prime numbers|
   |algorithm | The algorithm preferred by the user.|
   |timestamp | when the request is created by the user.|
   |numberOfPrimes | the number of primes lies between the given range.|
   |total time | the time elapsed while processing the user request|
   
###   Retrieve a particular log

```curl   
   $ curl -v localhost:8080/service-logs/{requestId}
```   

   
###   Delete a log
```curl     
   $ curl -X DELETE localhost:8080/service-logs/{requestId}
```   
   You can delete a particular log using the above command.
   
   
##   How to test

   You can test the correctness of the algorithm used to generate prime numbers using:
    
```
   $ mvn clean test
```
   If you are using Intellij IDE, then use:
```
          Go to the Maven tool window, click Lifecycle then Run test.    
  or
          Press Ctrl twice to open Run Anything then type mvn clean test then enter.      
  or 
          either Right-click and Run AlgorithmTests file 
```   
   



