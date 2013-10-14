import play.Project._

name := """NextGenSCPUI"""

version := "1.0-SNAPSHOT"

val springVersion = "3.2.4.RELEASE"

libraryDependencies ++= Seq(
  javaCore,
  javaJdbc,
  filters,
  "com.h2database" % "h2" % "1.3.168",
  "org.springframework" % "spring-context" % springVersion,
  "org.springframework" % "spring-jdbc" % springVersion,
  "org.springframework" % "spring-tx" % springVersion,
  "org.springframework" % "spring-expression" % springVersion,
  "org.springframework" % "spring-test" % springVersion % "test",
  "cglib" % "cglib" % "2.2.2"
)

playJavaSettings 
