/*
  yappl.se
  Author: Max Meldrum
*/

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives
import com.paulgoldbaum.influxdbclient._

object RestAPI extends Directives with JsonSupport {

  def main(args: Array[String]) {

    implicit val system = ActorSystem("yappl")
    implicit val materializer = ActorMaterializer()
    implicit val executionContext = system.dispatcher

    // Change so you can send in the IP as an argument
    val influxDB = InfluxDB.connect("192.168.0.8", 8086)
    val db = influxDB.selectDatabase("mydb")

    val route =
      post {
        path("dump") {
          entity(as[Request]) { request =>
            val point = Point("yappl")
              .addTag("host", request.hostName)
              .addField("cpu", request.cpu)

            db.write(point)
            complete("Done")
          }
        }
      }

    val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)
    println("Starting up server at localhost:8080")
    println("curl -H \"Content-Type: application/json\" -X POST -d '{\"hostName\":\"MaxHost\",\"cpu\": 0.00}' http://localhost:8080/dump")

  }
}