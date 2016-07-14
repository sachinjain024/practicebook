Spark DataFrames - Michael Armburst (Spark Summit West 2015)
------------------------------------------------------------

## Spark SQL
- In Spark 1.4, connect to any version of hive
- Connect existing BI tools to Spark through JDBC
- @michaelarmburst

## DataFrame
- Distributed collection of rows organized into named colmns
- DF knows the schema (datatype, columnname etc)
- SchemaRDD in Spark < 1.3
- Unified Interface
- load, save, saveAsTable are actions

## Parquet
- Efficient columnar storage format
- Compact binary encoding with delta and run-length encoding 
- Each column stored separately with index which allows skipping of unread columns
- Internally, keeps min and max for each column to increase speed of filters.
- spark-packages.org
- AVRO as reference implementation

## Custom Data Source
- format(className)
- In df, we get same performance in case of Python, Scala, Java and R.
- UDF ?

- Under the hood same optimization and execution plans are implemented for both SQl/ASt and Dataframes.
- Tungsten Compaction Encoding

- GroupBy on Datasets is based on Tungsten encoding
- RDDs is low level and has more control over defining DAG while
DFs and DataSets are built on top of it.