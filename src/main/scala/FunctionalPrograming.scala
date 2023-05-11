object FunctionalPrograming extends App {

  val simpleIncrementer = new Function[Int,Int] {
    override def apply(v1: Int): Int = v1 +1
  }


//  println(simpleIncrementer(1))

  val aMappedList: List[Int] = List(1,2,3,4)
  val aFilteredList = aMappedList.filter(_ <= 2)

//  println(aFilteredList)


  //  Higher-order functions

  val allPairs = List(1,2,3).flatMap(number => List('a','b','c').map(letter => s"$number-$letter"))
//  println(allPairs)

  // for comprehension
  val alternativePairs = for {
    number <- List(1, 2, 3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter"
  //equivalent to the map/flatMap chain above

  //  List; no puede mutar
  val aLists: List[Int] = List(2,4,6,8)
//  println(0 +: aLists :+ 10)

//  Sequences; puede ser mutable o inmutable
  val aSeq: Seq[Int] = Seq(2,4,6,8)
//  Vectors; fast Seq implementation

  // Sets; no duplicates
  val aSet = Set(1,2,3,1)
  aSet.contains(1)
  println(aSet+10)

//  Ranges
  val aRange = 1 to 1000
//  println(aRange.toList)

//  Tuples
  var aTuple = ("Anakin", "Jedi", 1999)

//  Maps

  val aPhonebook = Map(
    "Obi" -> 2 -> 1999 -> "e" -> "a",
    "other" -> Set(2, 1999, "e", "a"),
    "Anakin" -> 3,
  )

  println(aPhonebook("Anakin"))


  val listas = List(List(1,2), List(3,4), List(5,6))
//  println(listas.flatMap(lista => lista).map(number => List("a","b","c","d","f","g").map(letter => s"$number-$letter")))


  val filterMapList = List(1,2,3).flatMap(numero => List("z","x","w"))
//  println(filterMapList)

  val numeros1 = Set(1,2,3)
  val numeros2 = Set(3,4,5)
  val numeros3 = numeros1 ++ numeros2

  val numeros = List(1,2,3,4,5)
  println(numeros.foldLeft(15)(_ + _))


  val unMapa = Map(
    "uno" -> 1,
    "dos" -> 2,
    "tres" -> 3
  )

  println(unMapa.view.mapValues(x => x * 2))

  val unaSecuencia = Seq(1,2,3)
  val otrovalor = 1 +: unaSecuencia :+ 2

  val unaTupla = (1,2,"tres", "cuatro", 5)
  val tuplaIterator = unaTupla.productIterator

  println(tuplaIterator)


  val valorPresente : Option[Int] = Some(2)
  val valorAusente : Option[Int] = None

  println(valorPresente.flatMap(number => Some(number*2)))

  val stream = 1 #:: 2 #:: 3#:: Stream.empty[Int]

//  val lazyList = 1 #:: 2#:: 3#:: LazyList.empty[Int]

  val lazyList = LazyList.from(0).filter(_ % 2 == 0)
  println(lazyList.tail.tail.head)

  val anotherLazyList = LazyList.from(0).takeWhile(_ < 4)
  println(anotherLazyList.tail.tail.tail.head)

  val lazyListToSum = LazyList.from(0).take(10)
  println(lazyListToSum.foldLeft(1)(_ + _))

  val lazyListFlatMap = LazyList.from(0).flatMap(x => LazyList(x,x+1))
  println(lazyListFlatMap.take(4).toList)
}

