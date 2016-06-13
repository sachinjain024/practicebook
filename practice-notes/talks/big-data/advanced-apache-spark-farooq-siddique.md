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
- RDD DataSets April 2012
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
