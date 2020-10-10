package de.maxbundscherer.sbt.docker.test

import de.maxbundscherer.sbt.docker.test.services.WebServerService

object Main extends App {

  private val webServerService: WebServerService = new WebServerService()

  webServerService.start()

}
