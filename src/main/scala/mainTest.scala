// 224aed64
object Main {
  def main(args: Array[String]) = {
    class Point(var x: Int = 0, var y: Int = 0){
      override def toString: String = s"($x,$y)"

    }

    val origin = new Point()
    val point1 = new Point(1)

    println(point1)
  }

}
