package util

import org.apache.hadoop.hbase.client.{ConnectionFactory, HTable, Put}
import org.apache.hadoop.hbase.util.Bytes
import org.apache.hadoop.hbase.{HBaseConfiguration, HColumnDescriptor, HTableDescriptor, TableName}
import org.slf4j.{Logger, LoggerFactory}

object HBaseUtil {

  private val logger: Logger = LoggerFactory.getLogger(getClass)

  private val conf = HBaseConfiguration.create()
  private val connection = ConnectionFactory.createConnection(conf)
  private val admin = connection.getAdmin()
  private val instanceCountTableName = "InstanceCount"
  private val colocationStoreTableName = "InstanceCount"

  private def isTableExist(tableName: TableName) = {
    admin.tableExists(tableName)
  }

  def createTable(tableName: String, columnList: List[String]) = {
    val _tableName = TableName.valueOf(tableName)
    if (!isTableExist(_tableName)) {
      val tableDescriptor = new HTableDescriptor(_tableName)
      columnList.foreach {
        x => tableDescriptor.addFamily(new HColumnDescriptor(x))
      }
      admin.createTable(tableDescriptor)
      println(tableName + " table created..!!")
    } else {
      println(tableName + " table already exists")
    }
  }

  def createInstanceCountTable() = {
    val columnList = List("size")
    createTable(instanceCountTableName, columnList)
  }

  def createColocationStoreTable() = {
    val columnList = List("size")
    createTable(colocationStoreTableName, columnList)
  }

  def writeToInstanceCountTable(rowkeyValueList: List[(String, String)]) = {
    val table = new HTable(conf, instanceCountTableName)
    val sizeByteArray = Bytes.toBytes("1")
    rowkeyValueList.foreach {
      rowkeyValue =>
      {
        val rowKey = rowkeyValue._1
        val value = rowkeyValue._2
        val row = new Put(Bytes.toBytes(rowKey))
        row.addImmutable(Bytes.toBytes("size"), sizeByteArray,
          Bytes.toBytes(value))
        table.put(row)
      }
        table.flushCommits()
        table.close()
    }
  }

  def writeToColocationStoreTable(rowkeyValueList: List[(String, String)], size: Int) = {
    val table = new HTable(conf, colocationStoreTableName)
    val sizeByteArray = Bytes.toBytes(size.toString())
    rowkeyValueList.foreach {
      rowkeyValue =>
      {
        val rowKey = rowkeyValue._1
        val value = rowkeyValue._2
        val row = new Put(Bytes.toBytes(rowKey))
        row.addImmutable(Bytes.toBytes("size"), sizeByteArray,
          Bytes.toBytes(value))
        table.put(row)
      }
        table.flushCommits()
        table.close()
    }
  }

  def deleteTable(tableName: String) = {
    val _tableName = TableName.valueOf(tableName)
    if (admin.tableExists(_tableName)) {
      admin.disableTable(_tableName)
      admin.deleteTable(_tableName)
    }
  }
}


