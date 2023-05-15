import org.graalvm.compiler.lir.LIRInstruction.Use

object ContextualAbstraction {

  /**
   *  1 - context parameters/arguments
   */

  val aList: List[Int] = List(2,1,3,4)
  val anOrderedList: List[Int] = aList.sorted

//  Ordering
  given decendingOrdering: Ordering[Int] = Ordering.fromLessThan(_ > _)

// analogous to an implicit val
    trait Combinator[A] {
    def combine(x: A, y: A): A
  }

  given intCombinator : Combinator[Int]= new Combinator[Int]{
    override def combine(x: Int, y: Int): Int = x + y
  }

//  SAM - Single Abstract Method
  val intCombinatorMultiplication: Combinator[Int] = (x: Int, y: Int) => x * y

  val intCombinatorRest: Combinator[Int] = new Combinator[Int] {
    override def combine(x: Int, y: Int): Int = x-y
  }

  def combineAll[A](list: List[A])(using combinator : Combinator[A]): A =
    list.reduce((a,b) => combinator.combine(a,b))


  val theSum: Int = combineAll[Int](aList)
  val theMult: Int = combineAll[Int](aList)(using intCombinatorMultiplication)
  val theRest: Int = combineAll(aList)(using intCombinatorRest)

  /**
   *
   */

  def main(args: Array[String]): Unit = {

    println(anOrderedList)
    println(theSum)
    println(theMult)
    println(theRest)
  }
}
