package day01.task2

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

  it should "find the value even if the number 'one' is spelled out" in {
    val doc = new CalibrationDocument("one1")
    doc.summarize() shouldBe 11
  }

  it should "find the value even if the number 'two' is spelled out" in {
    val doc = new CalibrationDocument("two2")
    doc.summarize() shouldBe 22
  }

  it should "find the value even if the number 'three' is spelled out" in {
    val doc = new CalibrationDocument("three3")
    doc.summarize() shouldBe 33
  }

  it should "find the value even if the number 'four' is spelled out" in {
    val doc = new CalibrationDocument("four4")
    doc.summarize() shouldBe 44
  }

  it should "find the value even if the number 'five' is spelled out" in {
    val doc = new CalibrationDocument("five5")
    doc.summarize() shouldBe 55
  }

  it should "find the value even if the number 'six' is spelled out" in {
    val doc = new CalibrationDocument("six6")
    doc.summarize() shouldBe 66
  }

  it should "find the value even if the number 'seven' is spelled out" in {
    val doc = new CalibrationDocument("seven7")
    doc.summarize() shouldBe 77
  }

  it should "find the value even if the number 'eight' is spelled out" in {
    val doc = new CalibrationDocument("eight8")
    doc.summarize() shouldBe 88
  }

  it should "find the value even if the number 'nine' is spelled out" in {
    val doc = new CalibrationDocument("nine9")
    doc.summarize() shouldBe 99
  }

  it should "find the value even if 'one' and 'eight' are merged" in {
    val doc = new CalibrationDocument("oneight1")
    doc.summarize() shouldBe 11
  }

  it should "find the value even if 'two' and 'one' are merged" in {
    val doc = new CalibrationDocument("twone2")
    doc.summarize() shouldBe 22
  }

  it should "find the value even if 'three' and 'eight' are merged" in {
    val doc = new CalibrationDocument("threeight3")
    doc.summarize() shouldBe 33
  }

  it should "find the value even if 'five' and 'eight' are merged" in {
    val doc = new CalibrationDocument("fiveight5")
    doc.summarize() shouldBe 55
  }

  it should "find the value even if 'seven' and 'nine' are merged" in {
    val doc = new CalibrationDocument("sevenine7")
    doc.summarize() shouldBe 77
  }

  it should "find the value even if 'eight' and 'two' are merged" in {
    val doc = new CalibrationDocument("eightwo8")
    doc.summarize() shouldBe 88
  }

  it should "find the value even if 'eight' and 'three' are merged" in {
    val doc = new CalibrationDocument("eighthree8")
    doc.summarize() shouldBe 88
  }

  it should "find the value even if 'three', 'eight' and 'three' are merged" in {
    val doc = new CalibrationDocument("threeighthree")
    doc.summarize() shouldBe 33
  }

  it should "find the value even if 'eight', 'three' and 'eight' are merged" in {
    val doc = new CalibrationDocument("eighthreeight")
    doc.summarize() shouldBe 88
  }

  it should "find the value even if both ends are merged" in {
    val doc = new CalibrationDocument("eighthreethreeight")
    doc.summarize() shouldBe 88
  }

  it should "sum values correctly" in {
    val doc = new CalibrationDocument("""two1nine
                                        |eightwothree
                                        |abcone2threexyz
                                        |xtwone3four
                                        |4nineeightseven2
                                        |zoneight234
                                        |7pqrstsixteen""".stripMargin)
    doc.summarize() shouldBe 281
  }

}

