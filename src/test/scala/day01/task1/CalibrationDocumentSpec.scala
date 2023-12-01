package day01.task1

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class CalibrationDocumentSpec extends AnyFlatSpec with Matchers {

  behavior of "CalibrationDocument"

  it should "fail if the document content is not valid" in {
    val doc = new CalibrationDocument("25\nxx\n")
    an [IllegalStateException] should be thrownBy doc.summarize()
  }

  it should "find the value from first and last digits" in {
    val doc = new CalibrationDocument("1abc2")
    doc.summarize() shouldBe 12
  }

  it should "find the value from first and last digits nested in the line" in {
    val doc = new CalibrationDocument("pqr3stu8vwx")
    doc.summarize() shouldBe 38
  }

  it should "find the value from first and last digits only" in {
    val doc = new CalibrationDocument("a1b2c3d4e5f")
    doc.summarize() shouldBe 15
  }

  it should "find the value even from a single digit" in {
    val doc = new CalibrationDocument("treb7uchet")
    doc.summarize() shouldBe 77
  }

  it should "sum values correctly" in {
    val doc = new CalibrationDocument("""1abc2
                                        |pqr3stu8vwx
                                        |a1b2c3d4e5f
                                        |treb7uchet""".stripMargin)
    doc.summarize() shouldBe 142
  }

}

