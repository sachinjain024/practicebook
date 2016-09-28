### Could this be an alternative implementation of groupByKey using combineByKey ?

    data
      Partition 1: { (a,1), (a,2), (b,1), (c,6) }
      Partition 2: { (e,6), (d, 7), (a,4), (e, 5) }
    createCombiner 
      If Key is found for first time, create an empty array and insert the value.
    mergeValue
      If Key is found next time, its value is pushed into the array.
    mergeCombiners
      Concatenate the Arrays for the same key

Advantages
- All keys reduced locally before transmission over network
- One key will be transferred one time So number of network calls decrease
- Amount of data transferred is less because same key is not transferred again and again
- We can handle OOM if we can determine the number of keys after concatenation of Arrays won't fit into memory

#### Answer

    ???

### How Spark ensures there is less data transfer in coalesce than repartitioning ?

