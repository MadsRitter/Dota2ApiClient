organization := "substitu"
name := "dota2-api-client"
version := "0.0.1"
scalaVersion := "2.11.11"


scalacOptions := Seq(
  "-feature",
  "-unchecked",
  "-deprecation",
  "-encoding", "utf8",
  "-language:postfixOps",
  "-language:implicitConversions",
  "-language:higherKinds",
  "-target:jvm-1.7",
  "-Yclosure-elim",
  "-Yinline"
)

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-ws" % "2.5.1",
  "com.typesafe.akka" %% "akka-http" % "10.0.10"

)
