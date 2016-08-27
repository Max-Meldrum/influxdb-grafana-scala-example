name := "rest-api"

version := "1.0"

scalaVersion := "2.11.8"


libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-http-experimental" % "2.4.9",
    "com.typesafe.akka" %% "akka-http-spray-json-experimental" % "2.4.9",
    "com.paulgoldbaum" %% "scala-influxdb-client" % "0.5.1"
)