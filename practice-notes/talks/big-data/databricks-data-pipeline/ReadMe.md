Databricks' Data Pipelines: Journey and Lessons Learned
-------------------------------------------------------

Link: https://databricks.com/blog/2016/08/16/databricks-data-pipeline-on-demand-webinar-faq.html
Link: https://www.youtube.com/watch?v=RYlhAF-9yE4
Author: Burak Yaviz

## Complexity
- Fault tolerance
- Record processing atleast once or exactly once
- Resource management
- Scalability
- Maintainability

## ETL @ Databricks

### Use cases:
- Monitoring
- Debugging
- Usage analysis
- Product Design (A/B Test)

### Requirements
- Latency (secs)
- Security (ACL)

Sol: Spark + Databricks
- Spark: ETL jobs
- All development happens in notebooks (db notebooks)
- Allows adhoc debugging
- Allows ACLs

## Classic Lambda ETL Pipeline
- Central Messaging system
- It writes data as incremental/batch ETL engine
- Stored into storaage system

## DB Pipeline
- Use Amazon Kinesis
- All logs from customer deployments are sent to kinesis
- Databricks depl logs are also sent to kinesis
- Sent data back to Databricks dep
- Databricks FS: Wrapper over S3. Includes ACLs
- DB Jobs (Real-time analysis - Spark streaming, Sync daemon service - writes raw records batch to dbfs, ETL jobs - saves as parquet, Data Anaysis)
- DB automatically creats a spark cluster for you.

### Log Collection
- Fault tolerance

### Sync Collection 
- Paritioning by date and saves data to dbfs

### ETL Jobs
- Incremental Jobs
- Batch jobs
- Use same code
- Run as scheduled db jobs
- Writes to dbfs as parquet tables

## Lessons learned
- Partition pruning can save time+money
- Queries run faster. Improvement 2800 sec -> 15 sec. Big Improvement
- Dont partition too many levels. Metadata discovery cost
- Lots of list requests. Metadata discovery on S3 is exp. 
- Spark sql tries to referesh its metadata cache ven after write operations.
- Parquet creats summary metadata after spark jobs are run. It takes hours on drivers.
- Turn off parquet config summary metadata -> false

### Running ETL jobs in DB
- Prototypes in notebooks
- Creates library
- Fallsback to spon instances on AWS
- Allows you to configure cluster like spark version, size etc.

### Debugging
- Dump service logs UI. Asks for customer name, service name, start time, end time, timezone etc. (Good one)

### Monitoring
- Bar chart for logs with error.

### Data Analysis
- SparkR + ggplot2

## Future (Strucutured Streaming)
- Reduce complexity (Sync daemon + delta + batch jobs = single streaming job)
- Event time dashboards
- Reduce latency in data availability

Questions:
- How is lookup done ?
- Support of Hbase in DB pipeline ?