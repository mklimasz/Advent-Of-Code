object Puzzle2 {

  private var position: Int = 5
  /**
         1
    * 2  3  4
   5  6  7  8  9
    * 10 11 12
    *    15
    */
  def singleMove(c: Char): Unit = {
    c match {
      case 'U' => if ((position-4) > 0 && (position-4) % 4 != 1) position-=4
                  else if (position == 3 ) position = 1
      case 'D' => if (position == 1) position = 3
                  else if ((position+4) < 16 && (position+4) % 4 != 1) position +=4
      case 'L' => if (position != 1 && position != 2 && position % 5 != 0) position-=1
      case 'R' => if (position == 5  || position == 8 ||
        position != 15 && position %4 != 1 && position % 4 != 0) position+=1
    }
  }

  def mapToKeyBoard(position: Int): Unit = {
    position match {
      case 10 => print('A')
      case 11 => print('B')
      case 12 => print('C')
      case 15 => print('D')
      case others => print(position)
    }
  }

  def makeMove(chars: Array[Char]): Unit =  {
      for(c <- chars) {
        singleMove(c)
      }
      mapToKeyBoard(position)
    }

  def main(args: Array[String]): Unit = {
    io.Source.fromFile("./input.txt")
      .getLines()
      .foreach(line => makeMove(line.toCharArray))
  }
}
