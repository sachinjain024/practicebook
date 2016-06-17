Advanced Apache Spark by Farooq Siddique
----------------------------------------

Originated at AMP Labs (UCB)

### Blink DB
- Run SQL Query within in N seconds: Returns the results with an error percentage
- Run SQL query when confidence interval is 95 percent
- An experience over 100 nodes on AWS. Runs SQL query in 2 seconds on 17TB data with error of 2%

### Layers over Spark Core
- MLLib
- GraphX
- Tachyon
- BlinkDB
- Streaming
- SQL

### Time for reading data
- Reck: 12.5 MB/s (0.1 Gb/s)
- Network: 125 MB/s
- HD: 100 MB/s
- Solid State HD: 600 MB/s
- Memory: 1 GB/s

### Concept of Apache Spark

    HDFS -> MR -> HDFS -> MR -> HDFS -> MR -> ... -> DB
    HDFS -> Memory -> Spark -> Memory -> Spark .. -> DB

Usually in MR jobs, there are multiple MR phases in which writing on HDFS (or disks) are done.
Spark takes the advantage of this concept and does all this computation in memory. That's why it is very much faster.
K-Means clustering algorithm requires about 17 MR sequentials operations. Hence, this is much faster when done on spark.

### Name
Originally, Mesos was introduced and to prepare a POC of Mesos, spark was built. Name is given such that it sparks an echosystem of distributed slutering on top of Mesos. But it got life of its own.

### Papers
- RDD June 2010
- RDD DataSets April 2012: http://people.eecs.berkeley.edu/~matei/papers/2012/nsdi_spark.pdf
- Spark Streaming
- Spark SQL
- Blink DB
- GraphX

### Labs
- tinyurl.com/cdhsparklab
- tinyurl.com/dsesparklab

### Books
- Learning Spark
- spark-summit.org/east/training/devops

### RDD
- In general, 100-10K partitions
- Each partition is done by a task bia thread/core
- Partitions of data should be K(Number of nodes) for uniform parallelization
- Two ways of partition: Parallelize and read external file
- Spark does lazy evaluation
- Be careful with actions like collect, do not call collect when RDDs are TBs in size otherwise you get Out of Memory exception
- Code is actually evaluated when we call an action on it.
- Repartition: coalesce
- Don't cache base RDD but cache filtered RDD.
- *Important to know the type of RDD HadoopRDD, FilteredRDD, PairRDD, ShuffledRDD, MappedRDD*

#### Interface

RDD Interface has the following API
1. partitions: List of parititions
2. dependencies: List of dependencies a RDD has
3. compute: A function - how to compute that partition
4. Optional partitioner: Partitioner for key-valued RDD like HashPartitioned
5. Optional, locations: List of prefered locations to compute each partition

Example:

Filtered RDD
1. Same as Parent. There is a partition for each parent partition
2. Each partition is dependent on parent partition

### Parallelism

Spark can run in following modes
1. Local
2. Standalone (DataStack Casaandra distribution)
3. Yarn
4. Mesos

1,2: Static Partitioning of executors
3,4: Dynamic partitioning of executors

Dynamic partitioning: Suppose Yarn provides 10 cores/executors and then based on requirement it assigns 10 more executors.
Later when 10 executors are free then it will take away 10 executors from the cluster.

Static Partitioning: Assigns static number of executors for a job and Spark reserves those executors unless the job is finished.

Hadoop = Yarn + MR + HDFS
Spark is very high effective candidate to replace MR in hadoop stack.

#### How Spark is Fast ?

Every executor has slots where Map/Reduce task is run. Traditionally slots are fixed for Map and Reduce tasks. 
Later these taks are made generic. That means a slot can run both Map or Reduce task. When a Map operation is done on executor, Job manager assigns it one more Map job.
But this scheduling was inefficient and took time.

Facebook saw this opportunity and implemented Corona. Base idea of corona was to fill empty slots more aggresively. According to facebook, reassignment of a job in traditional hadoop architecture took 66 seconds while Corono took 55 seconds and thus ~17% percent. 

Spark does this job very well. Latency of Spark in assigning task to empty slots is very fast and it takes about 1.5-2 seconds.

## Running in idfferent modes

### Local mode
- When we start scala shell, it starts JVM = executor process + driver process
- There is no worker Or worker does nothing.
- You can change numCores => num parallel threads
- In general, we should set numCores = 2 or 3 times number of processors
- --master local[12] Here 12 is the numCores

### Standalone mode
- We submit the job with spark url e.g. spark://host1:port1
- SPARK_LOCAL_DIRS inside spark-env.sh
  - Disc is used for intermediate shuffle data
  - Disc is also used to store those partitions which do not fit into memory.
  - We can add more SSDs to each node in cluster so that they can use local disc for above two operations instead of using some external storage like S3.
  - Attach more SSDs to each node in cluster and set their mount points as comma separated to SPARK_LOCAL_DIRS.
- When spark is started, master JVM is launched on the one of the nodes and a worker JVM is launched on every node. 
- At this time, each worker JVM will register itself to master JVM
- These are not aplications and take relatively less memory to coordinate.
- When we submit a job to spark, a driver program is launched on one of the machines where we ssh and submit the job.
- Driver asks Master for executors for its job. and General practice is that an executor JVM is launched on each of the nodes.
- Worker only starts the executor JVM and If executor gets crashed, worker restarts it.
  - If worker crashes, master will restart it.
  - If a driver restarts, all executors will need to restart.
- SPARK_WORKER_CORES can be changed on the machine which has different configuration. spark-env.sh
- Master is made highly available (HA) by zookeeper
- One worker in standalone mode can not start two executors for same application. One worker can start two executors but for different applications
- But we can have multiple workers on same machine so basicaly we can set `SPARK_WORKER_INSTANCES` - Number of worker JVMs on each machine. Now, for an application we can have two executors on same machine but there is always an executor for a worrker.
- `SPARK_WORKER_CORES` - How many cores worker can give out to its underlying executors. (Factor of 2-3 of actual number of cores)
- `SPARK_WORKER_MEMORY` - How much memory worker can give out to executors.
- `SPARK_DAEMON_MEMORY` - Memory to allocate to Spark master and worker daemons themselves
- Apps submitted will run in FIFO mode by default.
- `spark.executor.memory` - Memory for each executor

Question: What if we set configurations like spark.executor.memory to 1 GB and SPARK_WORKER_MEMORY to 2 GB. It simply says there can be 2 executors per worker. Now, if we submit 3 applications on the cluster. What will happen ?
Me: OUT_OF_MEMORY Exception

### Spark Master UI
Memory: Say 4GB -> It means the amount of memory Spark cluster has access to. Sum of memory all workers can give to its executors. 

- There is a different setting which decides memory for driver.
- Depending upon use case, we should tune our cluster.
- Drivers and Executors are present in all types of cluster modes. The only difference is who starts the executor like in standalone mode Worker starts the executor.
- A Spark application is composed of multiple jobs and each job is decomposed into multiple stages. A stage contains multiple tasks.
- Storage Tab 
  - Shows RDDs cached or persisted
  - It can be used to confirm if RDD is unequally partitioned. Means we have 50 P but 90% of data is on 1 P. Just call cache on RDD, it should come in storage tab. RDDs which do not fit in mempry take size on disk which is alwo shown here.
- Environment
  - Defaults in scala source code 4th
  - Configuration files 3rd
  - spark submit 2nd
  - spark source code spark context 1st
- Executors
  - Gives thread dump
  - Track hotspotting

### Yarn Mode
