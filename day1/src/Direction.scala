sealed trait Direction {
  def direction: (Int, Int)
  def next(turn: String): Direction
}
case object NORTH extends Direction {
  override def direction: (Int, Int) = (0, 1)
  override def next(turn: String): Direction = if(turn.equals("L")) WEST else EAST
}
case object SOUTH extends Direction {
  override def direction: (Int, Int) = (0, -1)
  override def next(turn: String): Direction = if(turn.equals("L")) EAST else WEST
}
case object EAST extends Direction {
  override def direction: (Int, Int) = (1, 0)
  override def next(turn: String): Direction = if(turn.equals("L")) NORTH else SOUTH
}
case object WEST extends Direction {
  override def direction: (Int, Int) = (-1, 0)
  override def next(turn: String): Direction = if(turn.equals("L")) SOUTH else NORTH
}