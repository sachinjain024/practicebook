SkillSpeed - Apache Spark with Scala foundation course
------------------------------------------------------

## Links
- Course Content (LSM): https://skillspeed.wistia.com/projects/hwd8037vx4
- Speaker: Jayant Kumar

ibmbigdatahub - Four Vs of bd
Veracity - How genuine is data ? 

Google Research Papers: GFS and MapReduce is programming practice
HDFS based on GFS

Hadoop 

Pig, Hive, Hbase - components on top of Hadoop

NoSQl Technologies - MongoDB, Storm, Cassandra

Apache Spark - Started at UCB.

Storm - Streaming Technology (Most Robust) Java based

Spark - Real time analytics, perform machine learning 
Spark can also do streaming. 

Spark runs upto 100x times faster than Hadopp map reduce in "memory"

In MR, there are lots of disc IO operations that added slowness to the JOBS

Q: If Spark processes data in memory, how does big data fits into memory ?

In MR, mapper function reads data from disc and writes the data back to disc and then reducer reads that data from disc
Now, if there are many MR tasks, Spark optimizes this and avoids this Disc IO.

IBM declared that it would sponsor Apache spark

Before starting jobs, we decide how much data would be processed. 

If we have 1 MR job then performance will be same

Q: Cost effectiveness - Spark vs Hadoop ?

Since spark is faster (10-100 times), so time is improved

Core Spark components:
- Spark SQL
- Spark streaming: Near real time data capture
- MLib: Machine Learning Library
- GraphX: Graph Analytics 

Spark can run on hadoop, mesos

GraphX
- How many flights connect to a destination ? Data is in CSV
- 

Mesos: Cluster Management software

Q: How Mesos is different from Yarn ?

LinkedIn, Facebook: Example of Graph Processing

Google Knowledge graph

Spark 2.0 in June/July 2016

Scala: Martin Odersky and his team started developing Scala in 2001

Dynamically type language is where I can change the type of variable at run time
e.g Javascript
x = 10 
x = "hello"

Many frameworks like Spark, Kafka, Storm, Akka are written in scala
Play, Scalding, Akka - written in scala

LinkedIn, Twitter, Google etc are using Scala

Immutability is very important in distributed environment and multithreade environment

In Java, we should define final to a variable whenever we can

lazy declaration (Not evaluated)
but when you use the variable it will throw the exception if it has no content/value
Evaluation is done when it is used at first time

Read and understand more use case of "lazy"

Any is a type in scala. SuperType of number and strings.

val x = if (n > 0) "Positive" else 0
s: Any = 0

1 to 10 (10 is inclusive)
1 until 10 

var a = for (i <- 1 to 2) yield i*2
a is Vector(2, 4)
yield returns all the computed values inside for loop for each iteration and returns as vector object

Book: Programming in Scala
StackOverflow
Spark: Learning Spark

var a = new Array[Int](10);

Yes, there is null in scala
mapping.getOrElse('NY', 'No match found'); // Default value when key is not present

## Session 2 (Spark Basics)
---------------------------

Data Collection
- Flume
- Sqoop
UnStructured Data -> Flume -> Batch processing System
Structured Data -> Sqoop -> Batch processing system

Data Preparation (Processing)
- Pig
- MapReduce

Data Presentation (Visualization)
- ds.js
- tableau
- R (Multiple Packages available)

Hive internally uses Map Reduce

Kafka is a subscriber publisher model and there are logical entities called topics. It can hold data for certain period of time.
Applications subcribe to topics.

Spark - Hive integration is done with Hive context.

Sort and Shuffle phase is optimized in Spark (Multiple Disc IO operations)

Q: Can we say Spark will replace Hadoop ?
No - Spark will replace MapReduce but it runs on top of Hadoop.
It will always be compatible with Hadoop.

Basic Abstraction of Spark is RDD - Resilient Distributed Dataset
Resilient - Fault Tolerant

In simple words, we can say RDD is the way data is read into spark.
RDD is constructed into memory.

It can be constructed in 2 ways:
1. Manually
2. Reading a file

Spark context is needed to run a spark application. To run a spark context, we need spark config.
All details to executors are sent from Master node.

Once the code is exexcuted on slave nodes, result is sent back to master node.

Snapshot: Spark standalone cluster

SparkContext is also needed to construct RDDs as well.

If we need to process 128 Gb data then we need 128Gb (+ 64 gb buffer) = 192GB Memory is required.

RDDs Operations - Two types of actions which can be applied on RDDs.
- Transformation
- Action

Transformation would generate RDD back.
Action on an RDD gives result/value.

Transformations are computed only when action is called. Transformations are lazily evaluated.

RDDs are basically partitions in Spark.

cd DataScience/BigData/

It is under /Home/USER/SPARK-1.5.1-BIN/HADOP2.4/BIN

bin/spark-shell

We should see Scala shell again. In a spark shell, you do not have to create a spark context.
This is available in shell but if we are writing a program we need Spark context.

val inpPar = sc.parallelize(List("Hello", "Scala", "World"))
val lenRDdd = inpPar.map(x => x.length) // Gives RDD since map is a transformation

val resultRdd = inpPar.zip(lenRdd) // Gives Rdd of tuples (Zipping two Rdds)

resultRdd.collect // Gives back tupple. Collect is an action

inpPar.partitions.length // Returns the number of partitions based on the number of cores on the machine

When we are doing a manual construction of Rdds, we do parallelize.

var inp1 = sc.parellelize(1 to 10)

var mapRdd = inp1.flatMap(1 to _)
mapRdd.collect // Returns flattened objects like (1, 1,2, 1,2,3, 1,2,3,4)

val inp2 = sc.parellelize(1 to 10)
val filterRdd = inp2.filter(_ % 2 == 0)
inp2.collect

Master Node is not doing aggregation. Master does not do any computation.
Spark framework does the aggregation.

sc.parallelize - Constructing the RDD manually

_ acts as placeholder in Scala

val rdd = sc.textFile('a.txt');
rdd.count
val linesWithSpark = rdd.filter(line => line.contains("Spark")) //
linesWithSpark.count


