object Puzzle {

  def isTriangle(elements: Array[Int]): Boolean = {
    val max = elements.max
    max < (elements.sum - max)
  }

  def toTriangleNumber(triangles: Seq[Array[Int]]): Int = {
    var counter = 0
    for (triangle <- 0 to 2) {
      if(isTriangle(Array(triangles.head(triangle), triangles(1)(triangle), triangles(2)(triangle))))
        counter+=1
    }
    counter
  }

  def main(args: Array[String]): Unit = {
    println("Puzzle 1:")
    println(io.Source.fromFile("./input.txt")
      .getLines()
      .map(_.split(" ")
        .filter(!_.equals(""))
        .map(_.toInt))
      .count(isTriangle(_)))
    println("Puzzle 2:")
    println(io.Source.fromFile("./input.txt")
      .getLines()
      .map(_.split(" ")
        .filter(!_.equals(""))
        .map(_.toInt))
      .grouped(3)
      .map(toTriangleNumber(_))
      .sum)
  }
}
