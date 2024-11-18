object CallArguments extends App {
  def callByValue(x: Long): Unit = {
    println(s"Value ${x}") // 두 값 전부 같음: value를 넘겨준다.
    println(s"Value ${x}")
  }

  // Lazy evaluation: 함수 안에서 값을 처리하는 것
  def callByName(x: => Long): Unit = {
    println(s"Value ${x}") // evaluate -> 다른 값으로 출력
    println(s"Value ${x}") // evaluate again
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())
}
