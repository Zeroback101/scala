import scala.language.postfixOps

object MethodNotation extends App {
  class MyNumber(var value: Int) {
    // infix notation: 파라미터가 1개인 경우에만 가능
    def add(x: Int): Int = x + this.value 
    def subtract(x: Int): Int = this.value - x

    // prefix notation(unary notation)
    def unary_- : MyNumber = new MyNumber(-value)
    def unary_! : String = s"Sorry, not possible"

    // postfix -> import 필요
    def isZero: Boolean = this.value == 0

    // apply function
    def apply(): String = s"MyNumber is ${this.value}!"
  }

  // Create an instance of the class
  val myNumber = new MyNumber(10)

  // infix notation to call methods
  val result1 = myNumber add 5 // MyNumber.add(5)
  val result2 = myNumber subtract 8 // MyNumber.subtract(8)
  println(result1) // Output: 15
  println(result2) // Output: 2

  // prefix notation
  println(-myNumber.value)
  println(!myNumber)

  // postfix notation(Requires "import scala.language.postfixOps")
  println(myNumber isZero)
  println(myNumber.isZero)

  // apply
  println(myNumber.apply())
  println(myNumber())
}
