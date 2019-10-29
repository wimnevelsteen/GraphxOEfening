import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.functions._
import java.util.Properties
import java.sql.{Connection, DriverManager, ResultSet}
import org.apache.spark.graphx._
import org.apache.spark.rdd.RDD


object NeoApp {
  def main(args: Array[String]) {
    // all CPU cores and one-second batches of data
    var conf = new SparkConf().setAppName("Read CSV File").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)

    /*val tripdata = sqlContext.read.format("csv")
    .option("header", "true")
    .option("inferSchema", "true")
    .load("/home/wim/neo4jproject/data/tripdata.csv")

    val stations = tripdata
      .select("start_station_id", "end_station_id")

    stations.take(5).show() // this is just a station_id at this point*/

    // create vertices RDD with ID and Name
    val vertices=Array((1L, ("SFO")),(2L, ("ORD")),(3L,("DFW")))
    val vRDD= sc.parallelize(vertices)
    vRDD.collect().foreach(println)

    val nowhere = "nowhere"

    val edges = Array(Edge(1L,2L,1800),Edge(2L,3L,800),Edge(3L,1L,1400))
    val eRDD= sc.parallelize(edges)

    // define the graph
    val graph = Graph(vRDD,eRDD, nowhere)
    // graph vertices
    graph.vertices.collect.foreach(println)
    // (2,ORD)
    // (1,SFO)
    // (3,DFW)

    // graph edges
    graph.edges.collect.foreach(println)
    

  }
}
