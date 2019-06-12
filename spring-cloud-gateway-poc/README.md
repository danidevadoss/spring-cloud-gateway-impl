# Spring Cloud Gateway POC

This POC is to demonstrate spring cloud gateway communication. 
1.	Deploy producer app and gateway app
2.	Accessing <<gateway app>/test-path should fetch response from  <<producer app>/test-path
3.	Accessing <<gateway app>/test-request-rate-limit should fetch response from  <<producer app>/test-request-rate-limit  when the burst limit (redis-rate-limiter.burstCapacity) reaches gateway service should throw **"429 Too Many Requests"** as response

## Spring Cloud Gateway:

Spring Cloud Gateway aims to provide a simple, yet effective way to route to APIs and provide cross cutting concerns to them such as: security, monitoring/metrics, and resiliency.

## Routing Handler

Being focused on routing requests, the Spring Cloud Gateway forwards requests to a Gateway Handler Mapping – which determines what should be done with requests matching a specific route.

* Route – the primary API of the gateway. It is defined by a given identification (ID), a destination (URI) and set of predicates and filters
* Predicate – a Java 8’s Predicate – which is used for matching HTTP requests using headers, methods or parameters
* Filter – a standard Spring’s WebFilter

## Route

The routing configuration can be created by using pure Java or by using properties configuration

## Predicate Factories

Spring Cloud Gateway matches routes using the Spring WebFlux HandlerMapping infrastructure.
It also includes many built-in Route Predicate Factories. All of these predicates match different attributes of the HTTP request. Multiple Route Predicate Factories can be combined via the logical “and”.
Route matching can be applied both programmatically or via configuration properties file using a different type of Route Predicate Factories.

## WebFilter Factories

Route filters make the modification of the incoming HTTP request or outgoing HTTP response possible.
Spring Cloud Gateway includes many built-in WebFilter Factories.
Please find reference link for all predicates and webfilters



## RequestRateLimiter WebFilter Factory

The RequestRateLimiter WebFilter Factory takes three parameters: replenishRate, capacity, and keyResolverName.
* `replenishRate` – represents how many requests per second do you want a user to be allowed to do
* `capacity` – defines how much bursting capacity would be allowed
* `keyResolverName` – is the name of a bean that implements the KeyResolver interface

## Rate limiting
Rate limiting is mainly used to control the rate of traffic sent or received on the network. It helps to prevent decrease in the service quality or even outage due to high traffic and improve the reliability of the API. There are different types of rate limiting, each used to target a specific need.

The `RequestRateLimiter` takes an optional `keyResolver` parameter and parameters specific to the rate limiter. Notice that the key-resolver takes a SpEL expression referencing the bean with the name `userKeyResolver`. This bean implements the `KeyResolver` interface that help to derive the key for limiting requests:

```java
    @Bean
    KeyResolver userKeyResolver() {
        return exchange -> Mono.just("key");
    }
```

## Redis 
Replace actual redis host details in application.yml 

## Redis Mock

We found an existing in-memory Redis mock providing some basic functionality
The mock functions by creating a server which accepts web socket connections. Each Redis connection made to the mock creates a new RedisClient instance running on its own thread. The socket connections mimic the Redis protocol.

## How to Use It

To use the mock, you must first add a reference to it in your pom.xml with:
```XML
<dependency>
    <groupId>ai.grakn</groupId>
    <artifactId>redis-mock</artifactId>
    <version>0.1.3</version>
</dependency>
```

After that, you can start and stop your mock Redis server with:
```java
RedisServer server = RedisServer.newRedisServer(port);
server.start();
server.stop();
```
### Note:
if Redis Mock is used, if a mock instance is started once then `server.start()` can be commented in subsequent service start/restart

## Reference:
* https://cloud.spring.io/spring-cloud-static/spring-cloud-gateway/2.1.0.RELEASE/single/spring-cloud-gateway.html
* https://www.baeldung.com/spring-cloud-gateway
* https://aboullaite.me/spring-cloud-gateway/
* https://dzone.com/articles/java-redis-mock
