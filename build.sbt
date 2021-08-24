import Dependencies._

name := "json-to-csv"

version := "0.1"

scalaVersion := "2.13.6"

organization :="com.qbrainx"

organizationName := "QBrainX"

organizationHomepage :=Some(url("https://www.qbrainx.com/"))

startYear := Some(2021)

description := "A project to convert json to csv file"

libraryDependencies ++=compileDependencies
