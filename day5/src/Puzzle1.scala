import java.security.MessageDigest

object Puzzle1 {

  def main(args: Array[String]): Unit = {
    val doorId: String = "wtnhxymk"
    val result: String = Stream.from(0)
      .map(i => MessageDigest.getInstance("MD5")
        .digest((doorId + i).getBytes())
        .map("%02x".format(_))
        .mkString)
      .filter(_.startsWith("00000"))
      .map(_.charAt(5))
      .take(8)
      .mkString
    println("Puzzle 1 result:")
    println(result)
  }
}
