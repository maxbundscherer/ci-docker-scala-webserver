package de.maxbundscherer.sbt.docker.test.services

class WebServerService() {

  import akka.actor.typed.ActorSystem
  import akka.actor.typed.scaladsl.Behaviors
  import akka.http.scaladsl.Http
  import akka.http.scaladsl.model._
  import akka.http.scaladsl.server.Directives._
  import scala.io.StdIn

  def start(): Unit = {

    implicit val system = ActorSystem(Behaviors.empty, "my-system")
    // needed for the future flatMap/onComplete in the end
    implicit val executionContext = system.executionContext

    val route =
      pathEndOrSingleSlash {
        get {
          complete(
            HttpEntity(
              ContentTypes.`text/html(UTF-8)`,
              "<h1>Say hello to akka-http (v3)</h1>"
            )
          )
        }
      }

    val _ = Http().newServerAt("0.0.0.0", 8080).bind(route)

    println("Server v3 online at http://0.0.0.0:8080")

    /*println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
    StdIn.readLine() // let it run until user presses return
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done*/
  }

}
