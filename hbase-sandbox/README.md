# HBase

## Links
- http://hbase.apache.org/book.html
- https://www.kaggle.com/mylesoneill/game-of-thrones/

## Setup
- Set JAVA_HOME (to /usr) or wherever JAVA is defined
- Update conf/hbase-site.xml to define where 

### Hadoop Setup
- http://hadoop.apache.org/docs/stable/hadoop-project-dist/hadoop-common/SingleCluster.html

## Notes

Region Server Components
  - WAL (Write Ahead Log)
  - BlockCache (For frequent reads)
  - Memstore: Writes/Edits (There is 1 memstore per family)
  - HFiles
  - Maven Shade Plugin is used to create an uber jar with all dependencies.

> Note that this is one reason why there is a limit to the number of column families in HBase. 
There is one MemStore per CF; when one is full, they all flush. 
It also saves the last written sequence number so the system knows what was persisted so far.

## Steps to Run

### SparkWithHBase File

>    bin/spark-submit
>    --master local[4]
>    --class "work.AliasLookupGeneration" 
>    ~/personal/repo/practicebook/hbase-sandbox/target/uber-hbase-sandbox-0.0.1-SNAPSHOT.jar
