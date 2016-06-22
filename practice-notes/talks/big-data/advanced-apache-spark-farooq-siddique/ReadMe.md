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
- `spark.executor.memory` - Memory per executor

Question 
What if we set configurations like spark.executor.memory to 1 GB and SPARK_WORKER_MEMORY to 2 GB. It simply says there can be 2 executors per worker. Now, if we submit 3 applications on the cluster. What will happen ?

Me 
OUT_OF_MEMORY Exception

Answer 

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

### Yarn Mode (Yet Another Resource Navigator)
- Components: Resource Manager and Multiple Node Managers
- Resource manager has two components
  - App"s" Master: Restarts any app master (yellow) if it crashes. Not necessarily on same location where it was earlier. Other app (green) can run without interuptions.
  - Scheduler: Responsible for allocating app master and containers in different node managers.
- When we submit an app, resource master contacts node manager for resources and each of them will provide the latest resources information and then resource manager will start app master on one of the node managers.
- app master will ask resource manager for needed resources to run the app. resource manager will provide tokens and keys and ask app master to use token/key to ontian the containsers. 
- Once containers are created master will contact the client and does not need to contact resource manager unless more resources are needed.
- If an app has started and in between resource manager is crashed then app can continue working if it does not need any more resources.
- All containers talk to master and master also talks to client
- If app master goes down, resource manager will restart it. If app master is started on different node, application has to be restarted completely.
- RM is highly available via ZooKeeper

#### Client mode
- Driver runs on client e.g. Scala shell. Driver JVM is on machine which is submitting the job.
- App master is not spark master
- Executors are in direct contact with driver
- Executors are present in containers
- Resource M is doing what Spark M is doing in Standalone mode. Scheduling the executors.
- Multiple executors can be present on same machine.
- Scheduler inside driver JVM(Important Scheduler): It can decide where a task should run on. Basically, which executor. e.g. It can say a task should run on executor where a RDD partition is cached. Partition locality.
- Important thing to note: When we say we need 20 executors in 100 node cluster, we may get executors where we do not get data licality. Hdfs files are stores somewhere else. Cloudera is already working on this scenario. Talk exists on youtube.
- Problem in client mode is what is laptop where driver is running is removed from network. The whole application goes down. What if job takes more than 15-20 hours.

#### Cluster mode
- Driver is like python script or jar file and is run inside Yarn app master.
- Now, we cant call collect but we can save last RDD in DAG and save to HDFS.

#### Settings
--num-executors (Not available in standalone mode)
--executor-memory
--executor-cores

Dynamic Allocation: (spark.dynamicAllocation)
1. enabled
2. minExecutors: NUmber of executors that will start for an application (say 10).
3. maxExecutors
4. sustainedSchedulerBacklogTimeout - After this time out, resource manager checks if there is any pending tasks on driver because it assigned min executors initially. If yes, then it reassigns more executors 10->20. This timeout is called just once after start of application.
5. scheulderBacklogTimeout: This timeout keeps on calling after T (say 30 sec) to check if there are pending tasks on driver. RM will increase the executors exponentially now until we reach the limit of maxExecutors.
6. executorIdleTimeout: At this timeout, RM checks if a particular executor has not done any task for this time then it takes back from application and keeps doing that unless we reach minExecutors.

Source Code: ExecutorAllocationManager.scala

100 TB Sort Competition

### Persistence and Caching 

- RDD.cache = RDD.persist(MEMORY_ONLY)
- When we persist an RDD we can either persist it on disk or in memory. A partition can not be stored partially in disk and partially in memory.
- when we passs memory only flag and say  ehole partition vcan not be fit into memoty then the partiton is dropeed and it is either cmputed from undrlying sata scource or from some previos cahced ones in the DAG.
- This is LRU cache so oldest RDD will be evacuated from memory when new ones arrive and cache is full
- RDD.persist(MEMORY_ONLY_SER): It means it will store serialized RDD in memory which is space efficient. By default deserialized form of RDD is stored which takes more memory. It is important to choose fast serialization library. Java serialization is not too fast. 
- Storing serialized (byte array) also helps in GC signifaicantly because many individual records are stored in single block of memory.
- RDD.persist(MEMORY_AND_DISK): Deserialized in memory but serialized in disk
- RDD.persist(MEMORY_AND_DISK_SER): Serialized on both
- RDD.persist(DISK_ONLY)
- MEMORY_ONLY_2: Store in memory on 2 JVMs. When RDDS are too costly to lose.
- MEMORY_AND_DISK_2
- OFF_HEAP: (Tachyon): Sorted seralied objects in Tachyon. RDDs live in Tachyon even if Executors JVM restart.
- unpersist()
- Intermediate data is automatically persisted during shuffle operations (LOCAL_DIRS)
- 2

#### Executor memory is divided into three parts
- Cached RDDs
- Shuffle Memory
- User Program

If we face Out of Memory exception then it is most likely out of 2,3. Try to switch between User program and shuffle memory and observe the results.

### Serialization
Ser. in spark is used in the following:
1. Transferring data over network
2. Spilling data to disk
3. Caching to memory serialized
4. Broadcasting variables.

#### Library: Kryo (Faster than Java)
- conf.set('spark.serializaer', 'org.apache.spark.serializer.KryoSerializer')
- Recommended to be used in production
- We may need to register our classes in advance if they are going to ue KRYO for serialization

#### Garbage Collection
- High Churn: The cost of Garbage collection id difrectly proprtional to the number of hava objects. So it really matters the data structures we choose. For example an aray of ints is better than a link list.

- If we are using Spark Streaming, we should move to concurrent CMS GC
- Default is parallel


### Scheduling Process (Spark Jobs, Stages and Tasks)
- youtube talk: Spark Internals

- Construction of DAG from RDD Objects
- DAG Scheudler takes the DAG and divides into multiple Stages
- Each Stage (Or parallel stages) are given to Task Scheduler one by one
- Task Scheduler will break the stage into multiple tasks
- Task is given to executor
- Task is solved by multiple threads running in parallel

    DAG -> DAG Scheduler -> Task Scheduler -> Executor

### Dependencies

- Lineage dependencies can be Narrow dependency or wider dependency
- In narrow dependency, each parent RDD can be referred by atmost one child RDD. It means a parent will generate atmost one child RDD. Two parent RDDs can be combined to form a child RDD but a parent RDD can not generate two child RDDs.
- e.g. map, filter, union, join with inputs co-paritioned
- In wide dependencies, each parent RDD can create multiple child RDDs.
- e.g. groupByKey, join with inputs not co-partitioned
- When shuffle is caused, it is case of wide dependencies

### Stages
- When we read a text file from Hadoop, we get Hadoop RDD for an instant but soon it is converted to MappedRDD by Spark
- Use `toDebugString` to check lineage of RDD
 
### Shuffles
- numPartitions cause shuffle
- groupByKey, join cause shuffle
- We can pass preservesParitioning=true in map operation as 3rd argument so spark can trigger shuffle because it does not know what our lambda function is. If we are chaning keys, we might need repartition to have proper partitions acrss clusters.
- Cloudera blog post - Tuning Spark Jobs

### Accumulators and Broadcast variables
- One way to avoid shuffles is to make use of broadcast variables
- Send a large read-only lookup table to all the nodes
- Acc - Count events that occur duing job execution. Helps in debugging
- Mosharaf Chowdhury - Paper on broadcast
- Old Technique: HTTP (Sequential transfer to each executor. Driver bottleneck)
- New Technique: Bittorrent 
- Driver can read accum value
- Used to impl counters and sums efficiently in parallel
- Accum example
    val accum = sc.accumulator(0)
    val inputRDD = sc.parallelize(List(1,2,3))
    val m = inputRDD.map(l => { 
      accum += 1
      l*2 
    })
- Executors coordinate among themselves to collect/construct the file whose parts are sent by drivers. Bittorrent protocol

### 100 TB Daytona Sort competition
- sortbenchmark.org
- databricks blog spark sets a new record in large scale sorting
- Univ Sandiego worked on Trident sorting - a specially designed engined for sorting only.
- Sorting is really important for shuffling. It is really required in every aspect from SQL to Mllib.
- Sorting is challening because for 100 TB Data we need 500 TB IO and network bandwidth.

#### What made this possbile
- Sort based shuffle: SPARK-2045 
- Netty native network transport: SPARK-2468
- External shuffle service: SPARK-3796
- GC and cache improvements
- EC2 ?
- HDFS short circtuir local reads enabled ?
- Speculative execution ?
- hash and sort directory in spark source code

#### External Shuffle Service
- When a map operation is done by executor JVM, it spills data on LOCAL_DIRS. In standalone mode, Worker JVM provides that data to reducer working JVM. In Yarn Node manager does the same job. This is because to take off some load from executor JVM which is busy in sorting.
- In Yarn mode we should turn ON external shuffle service with dynamic allocation because executor is taken away by Res Manager  
when it is not active.
- In standalone mode, it is good to have

#### Serving Mapped Data
- Old Technique: Disk -> Linux Buffer -> Exec JVM -> NIC Buffer -> Network
- Technique called zero-copy
- Disk -> NIC Buffer -> Network

#### Old Hash based shuffle (<10K reducers)
- TimSort
- Suppose we have 4 Mappers and we want to map data which is goping to be consumed by 3 reduceers.
- Each Mapper will generate 3 small files (A, B, C). Now all As are going to be fed to Reducer_A and similarly for other files.
- Map operation is bound by IO and transfering data to reducer is bound by Network bandwidth.
- Moreover, when mapper is simultaneously writing to multiple files that means multiple file handlers are open at the same moment. If we have 10K reducers that means 10K file handlers are open and Linux kernel does handle large amount of open handlers gracefully. In SSDs there are no disk seek cost but we have buffers for each file and buffer management for all these open file handlers become costly.

#### Sort based shuffle (250K+ reducers)
- In the same case, suppose N mappers have to spill data which is going to be consumed by 3 Reducers. Now, Instead of opening 3 file handlers, each data block is sorted and dumped into one file. Point is there is only one handler open at a time at each mapper JVM.
- Now, each datablock is sorted and contains data which is going to be consumed by RedA, RedB and RedC. Each one of them will read from their specific offset in file.
- There can be many reducers now because we have removed the constraint on the number of open handlers. 
- Each mapper will read some bit of data block and sort it and use Merge sort to completely sort the data block and write into one big file. (Map side)
- Reducers again use TimSort to sort multiple files and write down the reduced data to HDFS.
- Reducer does not need to know from where in the file it has to start reading. It is the responsibioty of Worker or Node Manager to provie data to reducer.
- Hash based sort might be better than sort based for smaller number of partitions. Because it does not need to do map sort internally.

### Spark Streaming
- Written on top of Spark Core
- Breaks the input data (stream) and converts into micro batches every X seconds and give to Spark Core. Spark Core then use that data and process it and outputs some batches of data
- nc -lk ? Command ?
- Create an app to print the number of words
- You can think Streaming is like a race between Creating RDDs from input data and processing RDDs. If you do not process RDDs (dstream - processing latency) before new set of RDDs comes up, we start lagging behind. 
- There is long running thread on one of the executors (worker with driver) which listens for data on some port. It will receive the data and keep on collecting the data for batch interval B and after B is done, dstream is processed.
- If Processing latency P > B, then we need to architect the solution. One important technique is to decrease B because we may be collecting lot amount of data in B which Spark is not able to process in P. On the same line we should not decrease B to very small number otherwise it will hit minimum time for P.
- One receiver can be a bottleneck so we can setup multiple receivers. But this means double data and we need to perform Union. Two receivers can be setup to subsribe to two different topics.
- Transformations of Dstreams (Refer slide)
- Window Operations (E.g Do some analysis over data on previous 30 seconds and do this analysis every 10 seconds)
- Window Length: 3 Time units, Sliding Interval: 2 TIme Units (Ref. S)
- There exists common window operations and output operations on Dstreams