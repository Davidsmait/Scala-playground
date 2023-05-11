object Either extends App {

  def divide(dividendo: Int, divisor: Int): Either[String, Int] ={

    if (divisor == 0){
      Left("el divisor no puede ser cero")
    }else{
      Right(dividendo / divisor)
    }
  }

  val divisionEntreCero = divide(10,0)

  divisionEntreCero match
    case Left(value) => println(s"Error: $value")
    case Right(value) => println(s"el resultado es: $value")


  val divisionValida = divide(10, 5)

  val resultadoValido =divisionValida.fold(
    "Error: " + _,
    rightValue => s"resultado: $rightValue"
  )

  println(resultadoValido)
}
