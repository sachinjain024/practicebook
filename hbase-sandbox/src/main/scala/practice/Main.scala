package practice

import org.apache.hadoop.hbase.client.ConnectionFactory
import org.apache.hadoop.hbase.{HBaseConfiguration}
import util.HBaseUtil

object Main extends App {
  private val conf = HBaseConfiguration.create()
  val connection = ConnectionFactory.createConnection(conf)
  val admin = connection.getAdmin()
  private val _tableName = "practice"

  println("Creating table: " + _tableName)
  HBaseUtil.createTable(_tableName, List("cf1", "cf2"))

  println("Printing all tables:-\n")
  val listTables = admin.listTables()
  listTables.foreach(println)
}
