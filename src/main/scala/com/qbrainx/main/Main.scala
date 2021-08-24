package com.qbrainx.main

import config.AppConfig

import java.io.FileReader
import scala.util.{Failure, Success, Try}
import util._
object Main extends App {
 val jsonFile= Try(FileReader.readFile(AppConfig.config.getString("inputpath"))) match {
   case Success(value) => Some(value)
   case Failure(exception) => Option.empty
 }


}
