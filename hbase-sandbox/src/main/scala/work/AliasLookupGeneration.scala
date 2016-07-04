package work

import org.apache.hadoop.fs.Path
import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.client.{Put, HTable}
import org.apache.hadoop.hbase.mapreduce.TableInputFormat
import org.apache.spark.{SparkContext, SparkConf}
import it.nerdammer.spark.hbase._
import util.HBaseUtil

object AliasLookupGeneration {
  case class AliasTable(val tableName: String, val columnFamily: String, val columnName: String) {
    private val conf = HBaseConfiguration.create()

    def apply(tableName:String, columnFamily: String, columnName: String) = {
      conf.addResource(new Path("file:///home/sachin/swtools/hbase-1.1.2/conf/hbase-site.xml"))
      conf.set(TableInputFormat.INPUT_TABLE, tableName)
    }

    def createTableInHbase() = HBaseUtil.createTable(tableName, List(columnFamily))

    def createHTable() = new HTable(conf, tableName)

    def getConf = conf
  }

  def main(args: Array[String]) {
    // Initiate spark context with spark master URL. You can modify the URL per your environment.
    val sparkConf = new SparkConf().setAppName("Dump Key Vales to HBase using Spark")
    val sc = new SparkContext(sparkConf)
    System.setProperty("hadoop.home.dir", "/home/sachin/swtools/hadoop-2.7.1")

    // Load file data
    val file = "/home/sachin/work/data/alias/dpid_411/41199"
    val fileData = sc.textFile(file)
    val pairs = fileData.map(line => (line.split("\t")(0), line.split("\t")(1)))

    val aliasTable = new AliasTable("__aam_lookup_dataset_view__", "d", "aamId")
    aliasTable.createTableInHbase()

    pairs.toHBaseTable(aliasTable.tableName)
      .toColumns(aliasTable.columnName)
      .inColumnFamily(aliasTable.columnFamily)
      .save()

    /*
    // Put data into table
    val aliasHTable = aliasTable.createHTable()

    // Calling collect so that we can save all records in single connection
    // Otherwise we get NotSerializable exception of HTable
    // We are using aliasHTable (HTable) inside lambda function which is executed in driver
    // While rest of the code is executed in master/driver so Spark tries to serialize the class and send it to executors
    // but HTable is not serializable So doing it in single instance for now.
    // http://stackoverflow.com/questions/25250774/writing-to-hbase-via-spark-task-not-serializable
    pairs.collect().foreach(pair => {
      val p = new Put(pair._1.getBytes())
      p.add(aliasTable.columnFamily.getBytes(), aliasTable.columnName.getBytes(), pair._2.getBytes())
      aliasHTable.put(p)
      // print(pair._1 + " " + pair._2 + "\n")
    })

    aliasHTable.flushCommits()
    */
  }
}
