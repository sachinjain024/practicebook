## Is it right to say that we can only process amount of data which is less than memory available in cluster ?
- No, We can still process data bigger than amount of memory in cluster. As long as each machine is able to fit single partition of RDDs in memory, it should be able to process data.

## What is caching of RDD ? Since RDD is spread across different machines, will all machines cache that partition ?

## How does coalesce happen ? Is all data collected at single node again and then repartitioned ? E.g. `coalesce(2, shuffle=false)`

## How Stage boundaries are calculated ?