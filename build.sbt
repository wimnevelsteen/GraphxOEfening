name := "versie1"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.4.4",
  "org.apache.spark" %% "spark-streaming" % "2.4.4",
  "org.apache.spark" %% "spark-sql" % "2.4.4",
  "mysql" % "mysql-connector-java" % "5.1.39",
  "org.apache.spark" %% "spark-graphx" % "2.4.4"
)