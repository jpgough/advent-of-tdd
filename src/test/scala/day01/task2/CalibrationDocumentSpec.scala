package day01.task2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks


class CalibrationDocumentSpec extends AnyFlatSpec with Matchers with TableDrivenPropertyChecks {

  behavior of "CalibrationDocument"

  forAll(Table(
    ("content", "scenario"),
    ("", "empty content"),
    ("xx", "content without digits"),
    ("xx\n25", "content without digits in each line")
  )) {
    (content: String, scenario: String) =>
      it should s"fail on $scenario" in {
        val doc = new CalibrationDocument(content)
        an[IllegalStateException] should be thrownBy doc.summarize()
      }
  }

  forAll(Table(
    ("content",            "expected value", "scenario"),
    ("1abc2",              12,               "from first and last digits"),
    ("pqr3stu8vwx",        38,               "from first and last digits nested in the line"),
    ("a1b2c3d4e5f",        15,               "from first and last digits only"),
    ("treb7uchet",         77,               "even from a single digit"),
    ("one1",               11,               "even if the number 'one' is spelled out"),
    ("two2",               22,               "even if the number 'two' is spelled out"),
    ("three3",             33,               "even if the number 'three' is spelled out"),
    ("four4",              44,               "even if the number 'four' is spelled out"),
    ("five5",              55,               "even if the number 'five' is spelled out"),
    ("six6",               66,               "even if the number 'six' is spelled out"),
    ("seven7",             77,               "even if the number 'seven' is spelled out"),
    ("eight8",             88,               "even if the number 'eight' is spelled out"),
    ("nine9",              99,               "even if the number 'nine' is spelled out"),
    ("oneight1",           11,               "even if 'one' and 'eight' are merged"),
    ("twone2",             22,               "even if 'two' and 'one' are merged"),
    ("threeight3",         33,               "even if 'three' and 'eight' are merged"),
    ("fiveight5",          55,               "even if 'five' and 'eight' are merged"),
    ("sevenine7",          77,               "even if 'seven' and 'nine' are merged"),
    ("eightwo8",           88,               "even if 'eight' and 'two' are merged"),
    ("eighthree8",         88,               "even if 'eight' and 'three' are merged"),
    ("threeighthree",      33,               "even if 'three', 'eight' and 'three' are merged"),
    ("eighthreeight",      88,               "even if 'eight', 'three' and 'eight' are merged"),
    ("eighthreethreeight", 88,               "even if both ends are merged"),
    ("""two1nine
       |eightwothree
       |abcone2threexyz
       |xtwone3four
       |4nineeightseven2
       |zoneight234
       |7pqrstsixteen""".stripMargin,                281 , "sum correctly"),
  )) {
    (content: String, expectedValue: Int, scenario: String) =>
      it should s"find the value $scenario" in {
        val doc = new CalibrationDocument(content)
        doc.summarize() shouldBe expectedValue
      }
  }

}

