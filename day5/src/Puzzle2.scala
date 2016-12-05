import java.security.MessageDigest

object Puzzle2 {

  def main(args: Array[String]): Unit = {
    val doorId: String = "wtnhxymk"
    val result: Array[String] = Array("", "", "", "", "", "", "", "")
    Stream.from(0)
      .map(i => MessageDigest.getInstance("MD5")
        .digest((doorId + i).getBytes())
        .map("%02x".format(_))
        .mkString)
      .filter(_.startsWith("00000"))
      .map(s => (s.charAt(5), s.charAt(6)))
      .filter(t => Character.isDigit(t._1) && t._1.asDigit < 8)
      .map(t => {
        if (result(t._1.asDigit).isEmpty) result.update(t._1.asDigit, t._2.toString)
        t
      })
      .filter(t => result.count(e => e.isEmpty).equals(0))
      .take(1)
    println("Puzzle 2 result:")
    println(result.mkString)
  }
}
