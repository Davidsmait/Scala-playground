import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

object Advanced extends App {

//  lazy evaluation
  lazy val aLzyValue = 2
  val lazyValueWithSideEffect = {
    println("lazy!")
    43
  }

  val  eagerValue = lazyValueWithSideEffect + 1

//  "pseudo-collection": Option, Try
  def methodWhichCanReturnNull(): String = null
  val aOption = Option(methodWhichCanReturnNull())
  println(aOption)

  def methodWhichCanThrowException(): String = throw new RuntimeException()
  val aTry = Try(methodWhichCanThrowException())

  aTry match {
    case Success(value) => println(value)
    case Failure(exception) => println(s"exception $exception")
  }

  /**
   * Evaluate something on another thread
   * (asynchronous programming)
   */

  val aFuture = Future {
    println("Loading...")
    Thread.sleep(1000)
    println("I have a computed value.")
    67
  }

  Thread.sleep(1500)

  /**
   * Implicits basics
   */

  // #1 implicit arguments
  def aMethodWithImplicitArguments(implicit arg: Int): Int = arg + 1

  implicit val aImplicitInt: Int = 42
  println(aMethodWithImplicitArguments)

//  #2: implicits conversions
  implicit class MyImplicitInteger(n: Int){
  def isEven() = n % 2 == 0
}
  println(12.isEven())


}
