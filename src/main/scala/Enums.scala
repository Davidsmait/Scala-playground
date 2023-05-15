
object Enums {

  enum Permissions {
    case READ, WRITE, EXEC, NONE
  }

  enum PermissionsWithBits(val bits: Int) {
    case READ extends PermissionsWithBits(4) // 100
    case WRITE extends PermissionsWithBits(2) // 010
    case EXEC extends PermissionsWithBits(1) // 001
    case NONE extends PermissionsWithBits(0) //000

    def toHex : String = Integer.toHexString(bits)
  }


  def main(args: Array[String]): Unit = {
//    val read = Permissions.READ
//    println(read)

    val enums1 : PermissionsWithBits = PermissionsWithBits.READ
    println(enums1)
    val bitsString = enums1.bits
    println(bitsString)
    val hexString = enums1.toHex
    println(hexString)

  }
}
