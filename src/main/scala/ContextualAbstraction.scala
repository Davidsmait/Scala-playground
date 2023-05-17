import ContextualAbstraction.Person
import org.graalvm.compiler.lir.LIRInstruction.Use

object ContextualAbstraction {
  /**
   *  Where contextual args are useful
   *   -type classes
   *   -dependency injection
   *   -context-dependent functionality
   *   -type-level programing
   */


  /**
   *  1 - context parameters/arguments
   */

  val aList: List[Int] = List(2,1,3,4)

  val anOrderedList: List[Int] = aList.sorted
//  Ordering                           ↗️
  given decendingOrdering: Ordering[Int] = Ordering.fromLessThan(_ > _)

// analogous to an implicit val
    trait Combinator[A] {
    def combine(x: A, y: A): A
  }

  /**
   * Given places
   * -local scope
   * -imported scope
   * -the companions of all the types involved in the call
   *   -companion of List
   *   -the companion of Int
   * @return
   */

  given intCombinator : Combinator[Int]= new Combinator[Int]{
    override def combine(x: Int, y: Int): Int = x + y
  }

//  SAM - Single Abstract Method
  val intCombinatorMultiplication: Combinator[Int] = (x: Int, y: Int) => x * y

  val intCombinatorRest: Combinator[Int] = new Combinator[Int] {
    override def combine(x: Int, y: Int): Int = x - y
  }

  def combineAll[A](list: List[A])(using combinator : Combinator[A]): A =
    list.reduce((a,b) => combinator.combine(a,b))


  val theSum: Int = combineAll[Int](aList)
  val theMult: Int = combineAll[Int](aList)(using intCombinatorMultiplication)
  val theRest: Int = combineAll(aList)(using intCombinatorRest)

  /**
   *  Contextual bunds
   */

  def combineAll_V2[A](list: List[Int])(using Combinator[A]): A = ???
  def combineAll_V3[A: Combinator](list: List[Int]): A = ???


  /**
   *  2 - extension methods
   */

  case class Person(name: String) {
    def gret = s"hi $name, i love Scala"
  }

  extension (name: String) {
    def gret = Person(name).gret // "type enrichment"
  }

  val davidGret: String = "David".gret

  extension[A] (list: List[A]) {
    def combineAllExtension(using combinator: Combinator[A]): A = {
      list.reduce(combinator.combine)
    }
  }

  val sumExtension = aList.combineAllExtension


  def main(args: Array[String]): Unit = {

    println(anOrderedList)

    println(theSum)
    println(theMult)
    println(theRest)

    println(davidGret)

    println(sumExtension)
  }
}
