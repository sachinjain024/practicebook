Big Data Analytics with Spark and Scala
---------------------------------------

## Links:
- facebook.com/v2maestros
- https://spark.apache.org

## Big Data
- Data Sets (Large and Complex) that traditional data processing and storage techniques are inadequate
- Volume (TBs)
- Variety (Web, Photo, Videos, Audio)
- Velocity (Batch, Periodic, Real time)
- Veracity (Qualoty of data - dirty, noise, missing data, wrong types)

## Hadoop

Hadoop consists of 2 components
- Hadoop Distributed File System (HDFS)
- Map Reduce Programming Paradigm

- Unix Based (No Windows support)
- Natively built using Java

## HDFS

- Distributed file system
- Optimized for very large files
- Small files can cause performance issues
- Optimized for write-once read-many
- Fault tolerance by default and  No backups required (Replication)
- Runs on commodity hardware
- Moves code to where data resides because code << data

### Architecture
- Master Slave architecture
- One "NameNode" (master) per cluster which stores metadata of the cluster (which data on which node)
- One "DataNode") per slave node
- Newer architecture maintains secondary namenode or multiple namenode so that whole clsuter don't choke
when one namenode is down
- File is divided into data blocks of size 64MB default
- Each data block is replicated to multiple data nodes (3)
- Rack Aware: DataNodes are grouped with racks. 
A rack can be considered as group of nodes with same power supply or some other common properties.
- Replication of data is done in a way that it includes atleast 2 racks.

### MapReduce
- Parallel Nature of HDFS Data: Since Data blocks are divided on multiple nodes having processing capaibilities, we can use them for our jobs.
- Multiple MR jobs can be chained. Output of 1 MR can be consumed by another MR.

#### Components: 
- Job Manager
- Task Manager

Job Manager plans the execution of jobs at different data nodes. Works at NameNode (Master)
Task Manager executes the map, reduce functions. Works at Data Node.

YARN: Yet Another Resource Navigator. This is Map Reduce version2.
It is an improved version of Map Reduce.

#### What Map Reduce needs
- Mapper function
- Reducer function
- Files containing MR code (e.g. Jar in Jave, Python files in python)
- Inout directory
- Output directory

Important thing is that Job Manager sends above information to each Task Manager to perform an operation.

#### How MapReduce works

Map
- Works on single line of file
- Ouptus: key value pairs
- Mostly used for Data processing, cleansing, filtering.

Merge-Sort:
- Done by Hadoop framework
- Merges the output of multiple mappers and gives as input to reduce function
- Output is <key, list>
- If there are same keys present in output of different mappers, then the values are combined to list hence <key, list>

Reduce
- Works on key value pairs
- Works on one key at a time
- Output key and values
- Typically there is one reduce function but there can be multiple reduce functions
- Summarization, Analysis, Joins.
- Outputs the result in output directory

Split - contiguous HDFC blocks of data

### Hadoop Stack

*Sqoop*: Sql to Hadoop
*Flume:* Log Processing and update log files
Both are used for Data injestion in HDFS

*Pig:* Data Processing/Analytics - Programming language (Piglatin line sql)
Internally use map reduce

*Hive:* Interface (SQL like fnctionality). Define schema and write sql queries called hql queries.
Convert query into MR

*Mahout:* Run Machine Learning application.

*Custom MR jobs*

*Impala:* Does not use MR but similar to hive sql based queries.

*Hbase:* Column now db stored in hdfs

*Spark*: In memory computation of 

*Storm:* Real time streaming based on HDFS

*ZooKeeper:* Used for management. Internall stores metadata and what applications are running for each node.

*Oozie:* Jobs scheduler.
	
## Spark

- Open Source Cluster Computing Framework
- Developed to overcome limitations of Hadoop's Map reduce (disk based operations)
- Hadoop and MR are disk based and take a lot of time while Spark can process data in real time

### Use Cases
- Real Time Data Processing
- Interactive Analytics (via Spark Shell)
- High Performance batch computation
- Machine Learning
- Credit card fraud detection: Detect whether credit card is used by owner or not. (Has to be done in real time)
- Network Intrusion detection
- Advertisement Targeting

### Workflow
1. Load data from source (HDFS, NoSQL, S3, Real time sources)
2. Transform Data (Fliter, Clean, Join, Enhance)
3. Store Processed data (Memory, HDFS, NoSql)
4. Interactive Analytics (Shells, Spark SQL, third-party tools which support JDBC)
5. Machine Learning
6. Action

### Architecture

Programming: Scala, Python, R, Java
Library: Spark SQL, MLLib, GraphX, Streaming
Engine: Spark Core - Runs all the logic for distributed computing and returns the result
Management: Yarn, Mesos, Spark Scheduler
Storage: HDFS, Local FileSystem, NoSQL (Cassandra, MongoDB, HBase), S3 (Cloud Storage), RDBMS

- If you are inside SparkShell, it is the driver program (master)
- SparkContext is like Database connection.
- SparkContext -> Cluster Manager -> Worker Nodes
- Increasing the number of worker nodes, the more faster processing will be.

#### Spark Context
- Driver accesses Spark functionality throught SparkContext object
- Represents a connection to computing cluster
- Used to build Rdds
- Works with cluster Manager
- Manages executors running on Worker nodes
- Splits jobs as parallel tasks and executes them on worker nodes
- Paritioning of Rdds and distributes
- Collects results and return to Driver Program (Master / Shell)

#### Spark Modes
- Batch Mode (Run entire programs)
- Interactive Mode (Shell) Similar to SQL Shell
- Streaming Mode

Shell provides a spark context automatically

#### Lazy Evaluation
- Means Spark will not load or transform data unless an action is performed
  - Load file into RDD
  - Filter RDD
  - Count number of elements (Now, loading and filtering happens)

- Internall optimize operations and resource usage
- Easy for devs. Can write chaining operation
- Important to see errors found while executing actions. Error may be related to earlier transformations.


## Questions

### SQL works on Tables/Relations. How does Spark SQL work because there are no tables/relations in Spark ?

### What is Spark Context ? Why is it required ?

































