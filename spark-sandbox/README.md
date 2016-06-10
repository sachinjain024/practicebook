# spark-scala-sandbox
Sandbox for playing with Spark and Scala 

## Commands for building the project

### Building Jar

    sbt package

### Executing Code    
    ~/swtools/spark-1.5.1-bin-without-hadoop/bin/spark-submit --class="CountWords" --master local[4] target/scala-2.10/spark-scala-sandbox-project_2.10-1.0.jar 
    ~/swtools/spark-1.5.1-bin-without-hadoop/bin/spark-submit --class="CountValues" --master local[4] target/scala-2.10/spark-sandbox-project_2.10-1.0.jar
 
## References
- http://spark.apache.org/docs/latest/quick-start.html
