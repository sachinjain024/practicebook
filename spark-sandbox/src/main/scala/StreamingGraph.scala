import org.apache.spark.sql.{DataFrame, SparkSession}
import org.graphframes.GraphFrame

case class Record(v1: String, v2: String) {
  override def equals(that: Any): Boolean = ???
}

object StreamingGraph extends App {
  val spark = SparkSession
    .builder
    .appName("StreamingGraph")
    .getOrCreate()

  import spark.implicits._

  val lines = spark.readStream
    .format("socket")
    .option("host", "localhost")
    .option("port", 9999)
    .load()

  // Split the lines into words
  val recordsDS = lines.as[Record]

  val verticesDF: DataFrame = recordsDS.flatMap((record: Record) => {
    Seq(
      record.v1, // Set representative on each vertex as itself
      record.v2
    )
  }).toDF("vertexId")

  val edgeDF: DataFrame = recordsDS.map((r: Record) => {
    (r.v1, r.v2, false)
  }).toDF("src", "dest", "relationship")

  val graph = GraphFrame(verticesDF, edgeDF)
  val connectedGraph = graph.connectedComponents.run()

  connectedGraph.isStreaming

  val verticesWithComponentDF = connectedGraph.toDF("vertextId", "value")

  verticesWithComponentDF.collect

  /*
  // Start running the query that prints the running counts to the console
  val query = verticesWithComponentDF.writeStream
    .outputMode("complete")
    .format("console")
    .start()

  query.awaitTermination()
  */
}
