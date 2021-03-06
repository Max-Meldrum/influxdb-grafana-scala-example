import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.DefaultJsonProtocol

trait JsonSupport extends  SprayJsonSupport with DefaultJsonProtocol {
  implicit val requestFormat = jsonFormat2(Request)
}
