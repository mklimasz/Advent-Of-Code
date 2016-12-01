object Puzzle1 {

  private var direction: Direction = NORTH
  private var start = (0, 0)

  def move(move: (String, Int)): Unit = {
    direction = direction.next(move._1)
    start = (start._1 + move._2 * direction.direction._1, start._2 + move._2 * direction.direction._2)
  }

  def main(args: Array[String]): Unit = {
    io.Source
      .fromFile("input.txt")
      .mkString.split(",")
      .map(el => el.replace(" ", "").splitAt(1))
      .map(t => (t._1, t._2.toInt))
      .foreach(move)
    println("Puzzle 1 result:")
    println(Math.abs(start._1) + Math.abs(start._2))
  }
}
