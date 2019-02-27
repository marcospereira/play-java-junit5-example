name := """play-java-junit5-example"""
organization := "com.lightbend"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.8"

libraryDependencies += guice

// Add JUnit 5 dependencies. See https://github.com/maichler/sbt-jupiter-interface#usage
libraryDependencies ++= Seq(
  "net.aichler" % "jupiter-interface" % JupiterKeys.jupiterVersion.value % Test
)

// Verbose test execution. See https://github.com/maichler/sbt-jupiter-interface#framework-options
testOptions += Tests.Argument(jupiterTestFramework, "-v")

// Also configure verbose test execution to old JUnit test. See https://github.com/sbt/junit-interface#junit-interface
testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v")