import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.graphx._

/**
  *
  * @param id1 Id1
  * @param id2 Id2
  */
case class Person(id1: Long, id2: Long)

object ConnectedComponent {
  def main(args: Array[String]) = {
    val file = "data/connected-component-data2.txt"
    val sparkConf = new SparkConf().setAppName("Social Interaction Graph of User")
    val sc = new SparkContext(sparkConf)

    val fileData: RDD[String] = sc.textFile(file)

    val recordsRDD: RDD[Person] = fileData.map((line: String) => {
      val ids = line.split(" ")
      Person(ids(0).toLong, ids(1).toLong)
    })

    // Generate VertexRDD
    val vertexRDD: RDD[(Long, Long)] = recordsRDD.flatMap((p: Person) => {
      Seq(
        (p.id1, p.id1), // Set representative on each vertex as itself
        (p.id2, p.id2)
      )
    })

    // Generate EdgeRDD
    val edgeRDD: RDD[Edge[Boolean]] = recordsRDD.map((p: Person) => {
      Edge(p.id1, p.id2)
    })

    val graph = Graph(vertexRDD, edgeRDD)
    val cc = graph.connectedComponents()

    cc.triplets.take(20).foreach(println)
  }

  def getRepresentative(currentRep: Long, proposedRep: Long): Long = Math.min(currentRep, proposedRep)

}
