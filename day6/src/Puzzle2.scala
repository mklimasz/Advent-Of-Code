object Puzzle2 {

  def getListOfMaps(size: Int) : List[Map[Char, Int]] = {
    List.fill(size)(Map[Char, Int]() withDefaultValue 0)
  }

  def main(args: Array[String]): Unit = {
    io.Source.fromFile("./input.txt")
      .getLines()
      .foldLeft(getListOfMaps(8)) {
        (maps, line) => {
          (maps, line).zipped.map {
            (map, c) => {
              map + (c -> (1 + map(c)))
            }
          }
        }
      }
      .foreach(map => {
        print(map.toList
          .sortBy {case (k,v) => (v, k)}
          .head
          ._1)
      })
  }
}
