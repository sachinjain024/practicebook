/*
* Simple Program to check if there are multiple values for a same key in text file having records separated with space
*/

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD

object CountValues {
  def main(args: Array[String]) {
    val sparkConf = new SparkConf().setAppName("Count Values Application")
    val sc = new SparkContext(sparkConf)

    val file = "data/simplefile.txt"
    // val file = "/home/sachin/work/data/alias/dpid_411/sample.txt"
    // val file = "/home/sachin/work/data/alias/dpid_411/41199"
    val fileData = sc.textFile(file)

    val pairs = fileData.map(x => (x.split("\t")(0), x.split("\t")(1)))

    println("Total Records: ", pairs.count)
    println("Number of pairs with same key and different values: ", countValues(pairs))

    /*val reversePairs = fileData.map(x => (x.split("\t")(1), x.split("\t")(0)))
    println("Total Records: ", reversePairs.count)
    println("Number of pairs with different keys but same value: ", countValues(reversePairs))*/
  }

  def countValues(pairs: RDD[(String, String)]): Long = {
    val pairsWithGroupedValues = pairs.groupByKey()
    val pairsWithMultipleValues = pairsWithGroupedValues
      .map(row => row._2.size)
      .filter(value => value > 1 && value < 25)

    // val oddPair = pairsWithGroupedValues.filter(row => row._2.size > 400)
    // oddPair foreach println

    val h = pairsWithMultipleValues.histogram(24)
    h._2.indices.foreach(i => println(h._1(i) + "-" + h._1(i+1) + ": " + h._2(i)))

    pairsWithMultipleValues.count
  }
}
