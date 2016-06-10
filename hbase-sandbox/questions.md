HBase Learning
-------------

## Why do we need to set JAVA_HOME environment variable ? Where is it used ?

## What is the need of timestamp in each tuple (key-value pair) ?

## Why data is stored in column format ? 

## What is the advantage over CSV or TSV ?
Answer: CSV (Comma Separated values) can be preferred over TSV (Tab Separated Values) when you can expect "," in your data.

## What exactly are HMaster, HRegionServer and ZooKeeper ?

## Difference between HBase and HDFS ?
- HDFS is a distributed file system while Hbase is a database. HBase works on the top of HDFS.
- HBase needs to store its data in file system in some format and it works well with HDFS.

## What is the advantage of column family ?

## How data is stored on disk by HBase ?

## Can we pass our hash function to avoid hotspotting ?

## Is region server also a small cluster ?
Answer: Yes, A Region server has multiple regions. A Client always talks to Region server for reading and writing data to the regions.

## Where is the WAL (Write Ahead Log) file maintained ? RegionServer ?
Answer: Yes, Every RegionServer has a WAL file which stores the updates (writes/edits) which have not been persisted to disk yet.

What if regionserver fails, how is this partition recovered then ?
What is .META file is present on region server which is failed ?

## How and when a region is moved ?

# Why HBase recommends not to have a column family size of >2 ?