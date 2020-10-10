name := "sbt-docker-test"
organization := "maxbundscherer"
version := "0.1"
scalaVersion := "2.13.3"

enablePlugins(DockerPlugin, JavaAppPackaging)

dockerBaseImage := "openjdk:11-jre"
//dockerExposedPorts in Docker := Seq(8080)

val AkkaVersion = "2.6.8"
val AkkaHttpVersion = "10.2.1"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion
)
