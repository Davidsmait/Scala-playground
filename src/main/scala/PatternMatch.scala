object PatternMatch extends App{
//  Pattern matching
// switch expression
  val anInteger = 2

  val order = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => anInteger + "th"
  }

//  println(order)
// Case class decomposition
  case class Person(name: String, age: Int)

  val bob = Person("bob", 44)

  val personGetting = bob match {
    case Person(n,a) => s"name: $n age: $a"
    case _ => "you are not a person"
  }

//  println(personGetting)
// deconstructing tuples
  val aTuple = ("Bon", "Jovi")

  aTuple match {
    case (name, lastName) => println(s"her name was $name and his last name was $lastName")
    case _ => println("no matches")
  }

//  decomposing list
  val aList = List(1,2,3)

  val aListMatch = aList match {
    case List(_,_,_,_) => " 4 _"
    case List(_,2,_) => "list contains 2"
    case _ => "no match"
  }

  println(aListMatch)

}
