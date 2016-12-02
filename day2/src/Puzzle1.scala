object Puzzle1 {

  private var position: Int = 5

  def singleMove(c: Char): Unit = {
    c match {
      case 'U' => if ((position-3) > 0) position-=3
      case 'D' => if ((position+3) < 10) position+=3
      case 'L' => if (position % 3 != 1) position-=1
      case 'R' => if (position % 3 != 0) position+=1
    }
  }

  def makeMove(chars: Array[Char]): Unit =  {
    for(c <- chars) {
      singleMove(c)
    }
    print(position)
  }

  def main(args: Array[String]): Unit = {
    io.Source.fromFile("./input.txt")
      .getLines()
      .foreach(line => makeMove(line.toCharArray))
  }
}
