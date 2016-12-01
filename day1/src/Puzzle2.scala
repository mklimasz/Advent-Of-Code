import scala.collection.mutable

object Puzzle2 {

  private var direction: Direction = NORTH
  private var start = (0, 0)
  private var visited: mutable.Set[(Int,Int)] = mutable.Set[(Int, Int)]()


  def makeMoves(moves: List[(String, Int)]) : Unit = {
    for(move <- moves) {
      direction = direction.next(move._1)
      for(step <- 1 to move._2) {
        start = (start._1 + direction.direction._1, start._2 + direction.direction._2)
        if(visited.contains(start)) {
          return
        }
        visited += start
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val moves = io.Source
      .fromFile("input.txt")
      .mkString.split(",")
      .map(el => el.replace(" ", "").splitAt(1))
      .map(t => (t._1, t._2.toInt))
      .toList
    visited += start
    makeMoves(moves)
    println("Puzzle 2 result:")
    println(Math.abs(start._1) + Math.abs(start._2))
  }
}
