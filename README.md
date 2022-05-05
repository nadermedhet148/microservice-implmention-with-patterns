# microservice-implementation-with-patterns

# First pattern is Sage pattern (Choreography-based) : 

use-case :
implement transactions that span services?


implementation : 
Implement each business transaction that spans multiple services is a saga. A saga is a sequence of local transactions. Each local transaction updates the database and publishes a message or event to trigger the next local transaction in the saga. If a local transaction fails because it violates a business rule then the saga executes a series of compensating transactions that undo the changes that were made by the preceding local transactions.



# Second pattern is service discovery pattern : 

use-case :
service discover the location of anthore service ?

implementation : 

When making a request to a service, the client makes a request via a router (a.k.a load balancer) that runs at a well known location. The router queries a service registry, which might be built into the router, and forwards the request to an available service instance.

# Third  pattern is CQRS pattern : 

use-case :
implement a query that retrieves data from multiple services in a microservice architecture

implementation : 

Define a view database, which is a read-only replica that is designed to support that query. The application keeps the replica up to data by subscribing to Domain events published by the service that own the data.

# Forth pattern is event stream processing : 

use-case :
Event stream processing is often viewed as complementary to batch processing. Batch processing is about taking action on a large set of static data (“data at rest”), while event stream processing is about taking action on a constant flow of data (“data in motion”)

implementation : 

Event stream processing works by handling a data set by one data point at a time. Rather than view data as a whole set, event stream processing is about dealing with a flow of continuously created data. This requires a specialized set of technologies.
