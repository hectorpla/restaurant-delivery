# Specification

1. search restaurant by name

2. order: item, quantity, note about diet, delivery address

3. access for orders (status: not payed, placed, delivered)

4. payment: credit card credentials -> payment ID, timestamp, estimated time

# Need Analysis

## Domains
1. restaurant info (NoSQL for restaurant)

2. order info (Redis for pending orders)

3. payment (DB for payment history)


## workflow
order placement -> order completion (permanent storage) 
-> preparation completion (possibly cancel) -> delivery completion (possibly cancel)


# Services

1. restaurant search service

2. order placement service

3. order status service

4. edging service ()

# Post
## important factors out of 12
+ explicit dependencies
+ store config in the environment
+ treat backing services as attached resources
+ keep dev, staging, prod as similar as possible
+ treat logs as event streams

## features for micro-service architecture
+ each team gets one database and one service
+ shared caches are platform provided services that are shared for consistency