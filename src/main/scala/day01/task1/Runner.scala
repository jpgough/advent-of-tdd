package day01.task1

import utils.MyLittleFileReader

object Runner extends App {
  val content = MyLittleFileReader.readFile("/input01-1.txt")
  val doc = new CalibrationDocument(content)
  println(doc.summarize())
}
