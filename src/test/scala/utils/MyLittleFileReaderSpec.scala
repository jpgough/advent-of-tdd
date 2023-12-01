package utils

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class MyLittleFileReaderSpec extends AnyFlatSpec with Matchers {

  behavior of "MyLittleFileReader"

  it should "read files into strings" in {
    val expectedContent = """line1
                            |line2""".stripMargin

    MyLittleFileReader.readFile("/input.txt") shouldBe expectedContent
  }

}
