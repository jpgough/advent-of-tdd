package day01.task2

import scala.annotation.tailrec

class CalibrationDocument(content: String) {

  private val digits = Map(
    "0" -> 0,
    "1" -> 1,
    "2" -> 2,
    "3" -> 3,
    "4" -> 4,
    "5" -> 5,
    "6" -> 6,
    "7" -> 7,
    "8" -> 8,
    "9" -> 9,
    "one" -> 1,
    "two" -> 2,
    "three" -> 3,
    "four" -> 4,
    "five" -> 5,
    "six" -> 6,
    "seven" -> 7,
    "eight" -> 8,
    "nine" -> 9
  )

  @tailrec
  private def findFirstDigit(line: String): Option[Int] =
    if (line == "") None
    else digits.keys.find(line.startsWith) match {
      case Some(digitPrefix) => digits.get(digitPrefix)
      case _ => findFirstDigit(line.tail)
    }

  @tailrec
  private def findLastDigit(line: String): Option[Int] =
    if (line == "") None
    else digits.keys.find(line.endsWith) match {
      case Some(digitSuffix) => digits.get(digitSuffix)
      case _ => findLastDigit(line.init)
    }

  def summarize(): Int =
    content
      .split("\n")
      .map(line =>
        (findFirstDigit(line), findLastDigit(line)) match {
          case (Some(first), Some(last)) => first * 10 + last
          case _ => throw new IllegalStateException
        })
      .sum

}