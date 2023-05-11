import scala.beans.BeanProperty

object GetterSetter extends App {
  class Point {
    private var _x = 0
    private val bound = 100


    def x: Int = _x

    /**    metodo _=
     *
     *     Cuando se declara una variable mutable o una propiedad en una clase en Scala,
     *     automáticamente se genera un método setter correspondiente para esa variable utilizando la notación _=
     */
    def x_=(newValue: Int): Unit = {
      if (newValue < bound)
        _x = newValue
      else
        printWarning()
    }

    private def printWarning(): Unit = {
      println("WARNING: Out of bounds")
    }
  }


  val point1 = new Point
  point1.x = 111
  println(point1.x)

}
