Apache Spark
------------

## RDD
RDD - Resilient Distributed DataSet. 
Resilient: Fault tolerant. Data is replicated among datanodes and hence if some data gets lost, it can be recovered. 
Distributed: This means dataset is distributed among datanodes.

RDDs can be generated from Hadoop Inputformats (HDFS files) or transforming other RDDs.

RDDs have actions and transformations.
Actions return values
Transformation return pointers to new RDDs.

e.g. 
Action - count, first
Transformation - map, filter

Reduce function takes two parameters.
Values of two consecutive (key-value) pairs.

### How to find the maximum number of words in a line ?

> val textFile = sc.textFile("README.md")
> textFile.map(line => line.split(' ').size).reduce((a, b) => if ( a > b) a else b)

### Difference between Map and flapMap ?
> Reference: http://spark.apache.org/docs/latest/programming-guide.html#transformations
> http://apache-spark-user-list.1001560.n3.nabble.com/What-is-the-difference-between-map-and-flatMap-td2594.html

FlatMap = Map + Flatten
In map, each element is mapped to another element
In flatmap, each element produces 0 or multiple elements (Depends on Transformation function)

### Difference between reduce and reduceByKey ?










