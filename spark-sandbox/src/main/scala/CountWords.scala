/*
* Simple Program to count number of words in a text file
*/

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object CountWords {
  def main(args: Array[String]) {
    val file = "sachin-wiki.txt"
    val sparkConf = new SparkConf().setAppName("Count Words Application")
    val sc = new SparkContext(sparkConf)

    val fileData = sc.textFile(file).cache()

    val linesWithWordsCount = fileData.map(line => line.split(" " ).size)

    val totalNumberOfWords = linesWithWordsCount.reduce((wordsInLine1, wordsInLine2) => wordsInLine1 + wordsInLine2)

    println("Number of words in file are: ", totalNumberOfWords)
  }
}
