import java.time.LocalDate
import java.util.Date

object AuxiliarConstructor extends App{

  class Student(var name: String, var govId: String) {
    private var _applicationDate : Option[LocalDate] = None
    private var _studentId: Int = 0

    def applicationDate : Option[LocalDate] = _applicationDate
    def studentId: Int = _studentId

    def this(name: String, govId: String, applicationDate: LocalDate) = {
      this(name, govId)
      _applicationDate = Some(applicationDate)
    }

    def this(name: String, govId: String, studentId: Int) = {
      this(name,govId)
      _studentId = studentId
    }
  }

  val student1 = new Student("Gintoki", "21")
  val student2 = new Student("Kagura","363", LocalDate.now())
  val student3 = new Student("megane","947", 56)
  println(student2.applicationDate)
}
