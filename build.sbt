val scala3Version = "3.2.2"

lazy val akkaVersion = "2.8.2"
val akkaHttpVersion = "10.1.11"
lazy val root = project
  .in(file("."))
  .settings(
    name := "playground",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "0.7.29" % Test
    )
  )
