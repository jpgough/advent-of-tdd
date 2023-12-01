package day01.task2

import utils.MyLittleFileReader

object Runner extends App {
  val content = MyLittleFileReader.readFile("/input01-2.txt")
  val doc = new CalibrationDocument(content)
  println(doc.summarize())
}
