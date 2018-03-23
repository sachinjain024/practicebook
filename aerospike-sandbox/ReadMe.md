# Aerospike Sandbox

## Requirements
- Docker

## How to run aerospike
Run docker quick start terminal and execute the following command    
    
    docker run -tid --name aerospike1 -p 3000:3000 -p 3001:3001 -p 3002:3002 -p 3003:3003 aerospike/aerospike-server
    
## How to check in aerospike

1. Go to docker VM using following command

    docker exec -it aerospike1 bash
    
2. Run AQL

    aql
    
3. Show Sets

    show sets
    
4. Scan all rows for a set where "test" is namespace

    select * from test.set