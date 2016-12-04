object Puzzle1 {

  def isRealRoom(tuple: (Int, Array[String], String)): Boolean = {
    val word = tuple._2.reduceLeft((s1,s2) => s1 + s2)
    word.groupBy(_.toChar)
      .mapValues(_.length)
      .toList
      .sortBy({case (k,v) => (-v, k)})
      .foldLeft(tuple._3)((checkSum, t) =>
        if (checkSum.isEmpty)
          checkSum
        else if (checkSum.charAt(0).equals(t._1.toChar))
          checkSum.replaceFirst(checkSum.charAt(0).toString, "")
        else checkSum)
      .equals("")
  }

  def main(args: Array[String]): Unit = {
    println("Puzzle 1 result: ")
    println(io.Source.fromFile("./input.txt")
      .getLines()
      .map(_.split("\\["))
      .map(a => (a(0).split("-").last.toInt, a(0).split("-").dropRight(1), a(1).replace("]", "")))
      .filter(isRealRoom(_))
      .map(_._1)
      .sum)
  }
}
