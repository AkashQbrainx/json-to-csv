package com.qbrainx.util


import com.qbrainx.model.{Student, Students}

import spray.json.{RootJsonFormat, enrichString}
import spray.json.DefaultJsonProtocol._
import scala.io.Source
import scala.util.{Failure, Success, Try}

object JsonReader{
  def readFile(path: String): String = {
    Try(Source.fromFile(path)) match {
      case Success(source: Source) => {
        return source.getLines().mkString
      }
      case Failure(exception) => {
        return "Couldn't read the message" + exception.getMessage
      }
    }
  }

  implicit val memberJsonFormat: RootJsonFormat[Student] =
    jsonFormat4(Student)

  implicit val membersJsonFormat: RootJsonFormat[Students] = jsonFormat1(Students
  )


  def ToStudent(student : String) = {
    student.parseJson.convertTo[Student]
  }

  def ToStudents(students : String ) = {
    students.parseJson.convertTo[Students]
  }



}

