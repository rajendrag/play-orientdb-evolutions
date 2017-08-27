name := """play-orientdb-evolutions"""
organization := "com.rp.orientdb"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.11"


fork in run := false

//PlayKeys.externalizeResources := false

//sources in doc in Compile := List()

//val testOptions = "-Dconfig.file=conf/" + Option(System.getProperty("test.config")).getOrElse("application") + ".conf"


lazy val oEvolutions = project.in(file("."))
  .settings(
    scalaVersion := "2.12.2"
  ).aggregate(plugin)

lazy val plugin = project.in(file("plugin"))
  .enablePlugins(SbtTwirl).settings(
  Seq(
    name := "play-orientdb-evolutions",
    organization := "com.rp",
    version := "0.0.1",
    scalaVersion := "2.12.2",
    resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
    libraryDependencies ++= Seq(
      "com.typesafe.play" %% "play" % play.core.PlayVersion.current % "provided",
      "com.typesafe.play" %% "play-test" % play.core.PlayVersion.current % "test" excludeAll(ExclusionRule(organization = "org.specs2")),
      "org.scalatest" %% "scalatest" % "3.0.1" % "test"
    ),
    scalacOptions ++= Seq("-language:_", "-deprecation")
  ))
