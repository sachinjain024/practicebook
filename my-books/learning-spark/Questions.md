## Learning Spark Questions and Answers

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

#### Answer ???

### How Spark ensures there is less data transfer in coalesce than repartitioning ?

Suppose we want to reduce number of partitions from P to N. Spark picks P - N partitions and merge them with another P - N paritions.

### groupByKey(K, V) returns RDD(K, Iterable(V)). Figure out Iterable class. 

Iterable is an interface which has a contract to define an iterator to traverse the class which implements it.
So, In this case Iterable(V) means it returns an implementation which knows how to traverse over V type values.

### Difference between broadcast variables and variables shared in closure ?

    Shared Variable in Closure

    val x = 10
    rdd.map(r => {
      // Use x Here
    })

    When spark sends the closure definition to executors, it will also serialize x and sends x with the closure.

    Broadcast variable

    val x = 10
    val bcX = sparkContext.broadcast(x)

    rdd.map(r => {
      // Use bcX.value here to get x
    })

In case of closure spark sends x to each task/parition while in broadcast spark broadcasts x and every executor will use it as readonly shared value. Hence, network bandwidth is saved.

