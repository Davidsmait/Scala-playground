import scala.math.Fractional.Implicits.infixFractionalOps
import scala.math.Integral.Implicits.infixIntegralOps
import scala.math.Numeric.Implicits.infixNumericOps

trait Greeter {
  def greet(name:String): Unit =
    println("hello, "+ name+ "!")
}
object traits extends App {

  class DefaultGreeter extends Greeter {
    override def greet(name: String): Unit = super.greet(name)
  }

  class CustomGreeter[A](prefix: A)(postfix: A) extends Greeter {
    override def greet(name: String): Unit = {
      println(s"$prefix $name $postfix")
    }

    def sumOrConcatenation(midleIten: Int)(implicit ev1: A => Int): Unit = {
      val sum = ev1(prefix) + midleIten + ev1(postfix)
      println(sum)
    }
  }

  val defaultGreater = new DefaultGreeter()
  defaultGreater.greet("David")

  val customGreeter = new CustomGreeter[String]("hi! ")(", how are you?")
  customGreeter.greet("David")

  val customGreeterInt = new CustomGreeter[Int](1)(3)
  customGreeterInt.sumOrConcatenation(2)
}
