name := "scala-for-beginners" 

version := "1.0.0"

scalaVersion := "2.10.0"

resolvers ++= Seq(
    "Sonatype Releases" at "http://oss.sonatype.org/content/repositories/releases"
)

libraryDependencies ++= Seq(
"joda-time" % "joda-time" % "2.0",
"org.scalatest" %% "scalatest" % "1.9.1" % "test",
"org.scalacheck" %% "scalacheck" % "1.10.0" % "test",
"org.easytesting" % "fest-assert-core" % "2.0M10" % "test"
)
