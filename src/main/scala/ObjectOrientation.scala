import scala.language.postfixOps


//
object ObjectOrientation extends App {

  // Interface
  trait Herbivore
    def eat: Unit = println("im eating plants :D")


  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Animal {
    val name: String = "Estela :)"
    val age: Int = 0
    def extend: Unit = println("im extend from Animal")
    def eat(): Unit = println("eating because im ANIMAL")
    def sayName: Unit = println(name)
  }

  val anAnimal = new Animal

  //inheritance

  class Dog(override val name: String) extends Animal
  val aDog = Dog("Susume")

  aDog.extend
  println(s"the doggo name is: ${aDog.name}")

  class Crocodile extends Animal with Carnivore {
   override def eat(animal: Animal): Unit = println(s"eating a ${animal.name}")

    override def eat(): Unit = super.eat()
  }

  val aCrocodile = new Crocodile
  aCrocodile.eat()

  // subtype polymorphism   ???????????
  class Cat(override val name: String) extends Animal
  val aPolymorphAnimal: Animal = new Cat("")
  println(s"cat name: ${aPolymorphAnimal.name}")

//  anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("dinosaur eating")
  }

  dinosaur.eat(aCrocodile)


  abstract class WalkingAnimal {

  }

  // singleton object
  object MySingleton{
    val specialValue = 9098908
    def spacialMethod(): Int = 32234
    def apply(value: Any) = s"you write: $value"
  }
  println(MySingleton("wofwof"))

  object Bunny extends Animal with Herbivore {
    override def eat(): Unit = super.eat()
  }

  Bunny.eat()



  val multiplicar = (a:Int, b: Int) => a * b  //lambda
  def suma(primerArgumento:Int, segundoArgumento:Int): Int = primerArgumento + segundoArgumento
  println(s"el total de la suma es: ${suma(1,2)}")
  println(s"el total de la multiplicacion es: ${multiplicar(2,2)}")
  // case classes

  case class Person(name: String, age: Number)

  val Anakin = Person("Anakin",30)

//  exceptions
  try {
//    code that  can throw
    val x = 10/0
  }catch {
    case e: ArithmeticException => println(e)
  }

//  generics

  abstract class MyList[T]{
    def head: T
    def tail: MyList[T]
  }

  var aList: List[Int] = List(1,2,3)
  var first = aList.head
  var rest = aList.tail

}
