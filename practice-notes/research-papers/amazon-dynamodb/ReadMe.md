## Notes

- Dynamo provides Availability, Partitioning (AP System) and tried to achieve consistency in most scenarios.
- Data Paritioned and replicated via consistent hashing
- Use object versioning for consistency

### Assumptions and Requirements

*<u>Query Model</u>*
- Value is blob and usually less than 1 MB
- Primarily based on primary key lookup

*<u>Efficient</u>*
- Services must be able to configure dynamo to achive different levels of latency and throughput.

- In order to define performance of system, we usually need average, median and expected variance ?
- SLA means 99% of requests will be served under 2seconds given peak load of 500 requests per second. If the peak load rises, requests may take more time.
- Amazon computes SLAs based on 99.9th percentile of the distribution.

- Dynamo is an eventually consistent store.
- Traditional systems resolve conflicts at write time. If you are writing at old state, writes are rejected. If writes are not able to reach majority of nodes, they are rejected. But Amazon needs highly available store and always ready to be writable. User adds a product to shopping cart, this write must be made amidst any network failure. Dynamo resolves conflicts at readtime.

## Architecture

### Interface

    def get(key): (context, value)
    def put(key, context, value): Unit

### Partitioning
- DynamoDB uses consistent hashing which results in circular hash values. Next hash of highest value maps to smallest hash value. i.e. Mod function
- Each node is assigned a set of tokens/positions on the ring (Token ~ Virtual Node)
- When any data/key is to be inserted, it is converted to md5 (128 bit) and we find its position on ring
- This key is assigned to the next higher token/virtual node
- This is similar to HBase RegionServer serving multiple regions (KeySpace between two tokens ~ region)
- Each Node is responsible for serving key space between its tokens and the preceeding tokens

### Problems with Consistent Hashing
1. Non-uniform distrbution
2. Does not cater heterogenity of the system

### Solution
- Each node is assigned a set of tokens aka virtual nodes to improve load distribution

### Replication
- In order to achieve high availability, each key is replicated N times
- N is configurable
- Keys are replicated to N successive nodes but since we have virtual nodes we may have scenario when two or more virtual nodes belong to same physical node
- Hence, replication is done with skipping nodes so that we have replicated keys to distinct physical nodes
- List of nodes where a node replicates its keys is called Preference list 

### Object Versionsing
- Dynamo is eventually consistent system
- Writes happen asynchronously 
- There is a vector clock for each version of the object
- Vector clock is just a list of (node, counter) tuples
- node, counter represents how many times this object is updated by this node
- Same object can have parallel branches of versions and vector clock can help in resolving the conflicts
- Ex if vector clock of one object has less than equal to counters of vector clock of second objects then we can discard first

### Execution of get and put
- Quorum like system R+W > N
- min R reads to be successful to consider a read
- min W writes to consider successful writes. Remaining N-W writes may or maynot happen immediately but will happen eventually
- Coordinator generates vector clock for new object and replcaites to N-1 nodes

## Questions
- How does Dynamo achieve consistency using object versioning ?
- How to store (1,2) and (1,3) in dynamo ?


## To Further explore
- [ ] Consistent hashing
- [ ] Expected variance

