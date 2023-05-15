object EnumsExamples {

  enum EstadoRopa:
    case nuevo, usado, gastado

  case class Prenda(tipo: String, estado: EstadoRopa)

  val pantalon: Prenda = Prenda("Pantalon", EstadoRopa.usado)
  val camisa: Prenda = Prenda("Camisa", EstadoRopa.nuevo)
  val sudadera: Prenda = Prenda("Sudadera", EstadoRopa.gastado)


  def verificadorDeDesgaste(prenda: Prenda): Unit = prenda.estado match
    case EstadoRopa.nuevo =>  println(s"el/la ${prenda.tipo} su estado es nuevo")
    case EstadoRopa.usado =>  println(s"el/la ${prenda.tipo} su estado es usado")
    case EstadoRopa.gastado =>  println(s"el/la ${prenda.tipo} su estado es gastado")


  def main(args: Array[String]): Unit = {

    verificadorDeDesgaste(pantalon)
    verificadorDeDesgaste(camisa)
    verificadorDeDesgaste(sudadera)
  }

}
