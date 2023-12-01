package utils

import scala.io.Source

object MyLittleFileReader {
  def readFile(fileName: String): String = {
    val source = Source.fromURL(getClass.getResource(fileName))
    val content = source.getLines.mkString("\n")

    source.close()

    content
  }

}
