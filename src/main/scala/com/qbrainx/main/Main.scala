package com.qbrainx.main

import com.qbrainx.model.Students
import config.AppConfig
import com.qbrainx.util.{FileWritter, JsonReader}

import java.io.FileReader
import scala.util.{Failure, Success, Try}
import util._
object Main extends App {
  val fileContent: Option[String] = Try(JsonReader.readFile(AppConfig.config.getString("sourcepath"))) match {
    case Success(value) => Some(value)
    case Failure(exception) => Option.empty
  }

  if (fileContent.isEmpty) {
    FileWritter
      .logErrorToFile(AppConfig.config.getString("errorpath"), "no json file present ")
  } else {
    val students: Try[Students] = Try(JsonReader.toStudents(fileContent.get))
    students match {
      case Success(value) => {
        FileWritter.convertToCsv(value, AppConfig.config.getString("outputpath"),
          AppConfig.config.getString("errorpath"))
      }
      case Failure(exception) => {
     FileWritter
          .logErrorToFile(AppConfig.config.getString("errorpath"), exception.getMessage)
      }
    }
  }




}
