package day01.task1

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks


class CalibrationDocumentSpec extends AnyFlatSpec with Matchers with TableDrivenPropertyChecks {

  behavior of "CalibrationDocument"

  forAll(Table(
    ("content",   "scenario"),
    ("",          "empty content"),
    ("xx",        "content without digits"),
    ("xx\n25",    "content without digits in each line")
  )) {
    (content: String, scenario: String) =>
      it should s"fail on $scenario" in {
        val doc = new CalibrationDocument(content)
        an[IllegalStateException] should be thrownBy doc.summarize()
      }
  }

  forAll(Table(
    ("content",     "expected value", "scenario"),
    ("1abc2",       12,               "from first and last digits"),
    ("pqr3stu8vwx", 38,               "from first and last digits nested in the line"),
    ("a1b2c3d4e5f", 15,               "from first and last digits only"),
    ("treb7uchet",  77,               "even from a single digit"),
    ("""1abc2
        |pqr3stu8vwx
        |a1b2c3d4e5f
        |treb7uchet""".stripMargin, 142, "sum correctly"),
  )) {
    (content: String, expectedValue: Int, scenario: String) =>
      it should s"find the value $scenario" in {
        val doc = new CalibrationDocument(content)
        doc.summarize() shouldBe expectedValue
      }
  }

}

