object sealedTraits extends App {

  sealed trait Forma

  case class Rectangulo(altura: Int, ancho: Int) extends Forma
  case class Circulo(radio: Int) extends Forma

// Puede escribise tambien de esta manera
// val matchForma: Forma => Double =

  def matchForma(forma : Forma) = forma match
    case Rectangulo(altura, ancho) => altura * ancho
    case Circulo(radio) => Math.PI * radio * radio
  end matchForma

  val circulo = Circulo(4)
  val rectangulo = Rectangulo(5, 10)
  val encontrarForma = matchForma(circulo)
  println(encontrarForma)

}
