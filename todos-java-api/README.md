### How to run

Run this app locally executing the following command in the terminal:

    mvn package && java -jar target/todos-java-api-1.0-SNAPSHOT.jar

Now you can open [Postman](https://www.getpostman.com/downloads/) and in the body of you POST write
your GraphQL query pointing to *http://localhost:8080/graphql*.
