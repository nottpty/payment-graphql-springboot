# Demo Payment API 

### Intro
This project for GraphQl + Spring Boot.
The project uses graphql to create a simple payment schema to demonstrate the use of GraphQl
Query, Mutation functionality.

### Requirements
- Java 17
- PostgreSQL
- Basic Knowledge of GraphQl and Spring boot
- Intellij or IDE of your choice
- Postman for testing the API
- Docker

### What is GraphQl?

GraphQl is a query language that can be used to develop APIs which uses a different approach than the trditional
REST APIs. Unlike traditional REST APIs GraphQl allows the client to specify which data required and thus allowing multiple
queries in a single request. This helps to develop light weight manageable APIs.

Official documentation: [GraphQL](https://graphql.org/)

### How to execute
To run the project by docker and execute queries follow below steps:

``
.\mvnw clean install -DskipTests jib:dockerBuild
``
* In terminal cd the Root folder of project where we have docker-compose.yml

``
docker-compose up -d
``
* the endpoint exposed at : [localhost](http://localhost:8080/graphql)
* postman or any Http client can be used to test the graphql queries
*  [GraphiQL](http://localhost:8080/graphiql) is a browser-based user interface for interactively exploring the capabilities of, and executing queries against, a GraphQL API.

To stop all containers

``
docker-compose down
``


###  Example of some queries/mutations:
Note all queries and mutations in GraphQl are post Http requests.

#### Why only Post?
Well, there are few reasons:
* GraphQl itself is transport-agnostic, it's not specific to HTTP. A GraphQl service can execute documents outside the context of network requests.
* There is no body in a GET request, which means the query, variables and operation name all have to be set through query parameters which
  can easily cause server to return 414 status(URI too long)


##### Query example
get all payment transaction
 ```
  query {
    getAllPayment {
      id,
      finalPrice,
      points,
      datetime
    }
  }
```

get sales by start date and end date
``` 
query {
  getSaleByStartDateTimeToEndDateTime(
    startDateTime:"2023-03-23T00:00:00Z",
    endDateTime:"2023-03-24T00:00:00Z",
    order: ASC
  ) {
    datetime,
    sales,
    points,
  }
}
```

##### Mutation example

create new payment
```
mutation {
  createPayment(input: {
    price: 55.00, 
    priceModifier: 0.95, 
    paymentMethod: CASH, 
    datetime: "2023-03-23T01:00:00Z"
  }) 
  {
    id
    finalPrice
    points
    datetime
  }
}
``` 
