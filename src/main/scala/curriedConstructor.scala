object curriedConstructor extends App{

  class Anime[A](name: String = "isekai generico")(genero: A = "Isekai"){
    def sayAnimeName(): Unit = {
      println(s"anime name: $name")
    }

    def sayAnimeGenero(): Unit = {
      println(s"genero del anime: $genero")
    }
  }

  object Anime{
    def apply(name:String)(genero: String) : Anime[String] = {
      new Anime[String](name)(genero)
    }

    def apply(name: String)(genero: Int): Anime[Int] = {
      new Anime[Int](name)(genero)
    }

    def apply(name: String)(): Anime[String] = {
      new Anime(name)()
    }

    def apply(): Anime[String] = {
      new Anime()()
    }

  }

  val anime1 = Anime("konosuba")("fantasia")

  anime1.sayAnimeName()
  anime1.sayAnimeGenero()
}
