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

    var influxIP = None: Option[String]

    if (args.length == 1) {
      val ip = args(0)
      influxIP = Some(ip)
    }

    val influxDB = InfluxDB.connect(influxIP.getOrElse("localhost"), 8086)
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
  }
}