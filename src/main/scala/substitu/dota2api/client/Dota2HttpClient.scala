package substitu.dota2api.client

import akka.actor.ActorSystem
import akka.http.scaladsl.model.{HttpMethod, HttpMethods}
import akka.stream.Materializer
import play.api.libs.json.JsValue
import play.api.libs.ws.WSResponse
import play.api.libs.ws.ahc.AhcWSClient

import scala.concurrent.Future

/**
  * Created by ritter on 16-09-17.
  */
trait Dota2HttpClient {
    def get(endpoint: String, params: Map[String, Seq[String]] = Map.empty): Future[JsValue]
}

class Dota2HttpClientImpl(protected val baseUrl: String, apiKey: String)(implicit val system: ActorSystem, mat: Materializer) extends Dota2HttpClient {

  private def uriFor(resource: String) = s"${baseUrl}$resource?key=$apiKey"

  private val customHeaders = "Accept" -> "application/json"
  private val http = AhcWSClient()

  private def expectOkJson(resp: Future[WSResponse], url: String, method: HttpMethod, body: Option[JsValue]): Future[JsValue] = {
    resp.map { response =>
      response.status match {
        case 200 | 201 => response.json
        case status =>
          throw new IllegalStateException(s"Status from Voxbone is not OK for $resp, response is: ${response.body}, request was sent to ${method.toString()} $url")
      }
    }
  }

  private def generateParamString(params: Map[String, Seq[String]] = Map.empty): String = {
    if(params == Map.empty) "" else params.flatMap{
      case (key, list) =>
        list.map{
          v => s"$key=$v"
        }
    }.mkString("&")
  }

  override def get(endpoint: String, params: Map[String, Seq[String]]): Future[JsValue] = {
    val paramString: String = generateParamString(params)
    val url = uriFor(s"$endpoint$paramString")
    val query = http.url(url).withHeaders(customHeaders).get()
    expectOkJson(query, url, HttpMethods.GET, None)
  }
}