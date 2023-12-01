package day01.task1

class CalibrationDocument(content: String) {

  def summarize(): Int = {
    val lines: Seq[String] = content.split("\n")
    val digitsOnly = lines.map(_.filter(_.isDigit))

    if (digitsOnly.exists(_.isEmpty)) throw new IllegalStateException

    digitsOnly.map(line => {
      val firstDigit = Character.getNumericValue(line.head)
      val lastDigit = Character.getNumericValue(line.last)
      firstDigit * 10 + lastDigit
    }).sum
  }

}