# Description
this service provides restaurant search (main) and also integrates restaurant menu service (side)

# DB design
1. restaurant id -> name, address
2. for each restaurant: list/hash of (item, price), id (optional)
3. for the menu, more complex menu could be possible {name, price, description, ...}

# some thoughts
+ whether should separate the menu service is not clear
+ for small scale to start, it is convenient, but should think about extendability
+ what should be the backing DB for menu service: RDB sounds not fit to store list
+ initially consider using Redis


# Development steps

1. restaurant service
2. menu service


# Tests
+ not reasonable to unit test spring boot data JPA, use integration test instead [stack-overflow](https://stackoverflow.com/questions/23435937/how-to-test-spring-data-repositories?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa)
+ integration testing spring boot (http://www.baeldung.com/spring-boot-testing)
+ in test env, use h2 instead to replace mySQL