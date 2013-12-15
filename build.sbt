name :="scala-scratch"
 
version :="1.0"

libraryDependencies ++= Seq(
    "org.scalatest" % "scalatest_2.10" % "2.0" % "test",
    "commons-io" % "commons-io" % "2.4",
    "joda-time" % "joda-time" % "2.3",
    "org.joda" % "joda-convert" % "1.5"
)

scalacOptions in ThisBuild ++= Seq("-unchecked", "-deprecation")