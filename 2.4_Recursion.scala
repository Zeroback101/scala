// Stack Recursion의 문제: stack overflow가 일어날 수 있다. 
// 각 스택 영역은 메모리 영역을 차지하므로 recursion 깊이가 깊어지면 오버플로우가 일어날 수 있다.

// tail Recursion: 

object Recursion extends App {

  // Iteration
  def factorialIterative(n: Int): BigInt = {
    var result = BigInt(1)
    for (i <- 2 to n) { // both ends are inclusive
      result *= i
    }
    result
  }
  println(factorialIterative(3))

  // Recursive
  def factorialStackRecursive(n: Int): Int = {
    if (n <= 1) 1
    else n * factorialStackRecursive(n - 1)
  }
  println(factorialStackRecursive(3))

  // tail Recursive
  def factorialTailRecursive(n: Int, accumulator: Int = 1): Int = {
    if (n <= 1) accumulator
    else factorialTailRecursive(n - 1, n * accumulator)
  }
  println(factorialTailRecursive(3))

  // @tailrec: tail Recursive인지 확인 가능
  @tailrec
  def concaternateRecursion(word: String, count: Int, accumulator: String): String = {
    if (count <= 0) accumulator
    else concaternateRecursion(word, count - 1, word + " " + accumulator)
  }

  println(concaternateRecursion("Hello", 3, ""))
}
