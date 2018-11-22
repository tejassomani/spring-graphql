Graphql with spring-boot

What is Graphql
From graphql.org
  GraphQL is a query language for APIs and a runtime for fulfilling those queries with your existing data.
  
It is schema driven i.e the schema is pre-defined and client is aware of it. Depending on the requiremnt, clients can decide to fetch either all/some of the data.

Graphql addresses

a) Over/Under fetching. With traditional REST API's there is always the issue of either fetching all of the data (more than needed) or fetching less (in this case, need to make more REST calls to get data)

b) Have a common API that can work for different requests (Web UI, Apps, or other API's)

c) Reduce trip times and cost


Here's an implementation of graphql with Java spring boot
