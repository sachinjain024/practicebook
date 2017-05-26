## Notes

- Dynamo provides Availability, Partitioning (AP System) and tried to achiev consistency in most scenarios.
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


## Questions

- How does Dynamo achieve consistency using object versioning ?
- How to store (1,2) and (1,3) in dynamo ?


## To Further explore
- [ ] Consistent hashing
- [ ] Expected variance

