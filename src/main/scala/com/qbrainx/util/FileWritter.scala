package com.qbrainx.util

import com.qbrainx.model.{Student, Students}

import java.io.PrintWriter
import scala.util.{Failure, Success, Try}

object FileWritter {
  def convertToCsv(students: Students, outputPath: String, errorPath: String): Any = {
    val fieldNames = students.student.head.productElementNames
    val fieldValue: List[Student] = students.student

    Try(new PrintWriter(outputPath)) match {
      case Success(value) => {
        val header: String = fieldNames.foldRight("")((prev, current) => prev + "," + current)
        value.println(header)
        Try(fieldValue.map(f => {
          val mobileValue: String = f.mobile match {
            case None => ","
            case Some(value) => value.toString + ","
          }
          val rowValue = f.id + ","+  f.fName + ","+  f.lName + ","+ mobileValue
          value.println(rowValue)
        }))
        value.close()
      }
    }
  }

  def logErrorToFile(path: String, errorMessage: String): Unit = {
    Try(new PrintWriter(path)) match {
      case Success(value) => value.println(errorMessage)
        value.close()
      case Failure(exception) => println("Couldn't write the Error to the File")
    }
  }
}



