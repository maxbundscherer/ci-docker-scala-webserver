name := "sbt-docker-test"
organization := "maxbundscherer"
version := "0.1"
scalaVersion := "2.13.3"

enablePlugins(DockerPlugin)

dockerfile in docker := {
  val jarFile: File = sbt.Keys.`package`.in(Compile, packageBin).value
  val classpath = (managedClasspath in Compile).value
  val mainclass = mainClass.in(Compile, packageBin).value.getOrElse(sys.error("Expected exactly one main class"))
  val jarTarget = s"/app/${jarFile.getName}"
  // Make a colon separated classpath with the JAR file
  val classpathString = classpath.files.map("/app/" + _.getName)
    .mkString(":") + ":" + jarTarget
  new Dockerfile {
    // Base image
    from("openjdk:11-jre")
    // Add all files on the classpath
    add(classpath.files, "/app/")
    // Add the JAR file
    add(jarFile, jarTarget)
    // On launch run Java with the classpath and the main class
    entryPoint("java", "-cp", classpathString, mainclass)
  }
}

imageNames in docker := Seq(
  // Sets the latest tag
  ImageName(s"${organization.value}/${name.value}:latest"),

  // Sets a name with a tag that contains the project version
  ImageName(
    namespace = Some(organization.value),
    repository = name.value,
    tag = Some("v" + version.value)
  )
)