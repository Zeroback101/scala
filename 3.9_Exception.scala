// 예외 처리
// 기대하지 않았던 결과에 대해 체크하고 처리하는 것
// NullPoint: 어떤 오브젝트가 null이다.
// ArrayIndexOutOfBounds: 배열 인덱스에서 벗어남.

// handle: 자바의 Throwble을 상속받음
// 1. Exception: 상대적으로 심하지 않은 문제가 일어났을 때 잡는 것
// 2. Error: 심각한 문제, OutOfMemory 같은...
// 사용법: throw 키워드 사용, Try 클래스 사용, finally(Exception이 일어나도 실행됨)를 catch 밑에도 사용

object Exceptions extends App {
  // throw keyword
  // throw new IllegalArgumentException("Invalid argument")

  def divide(x: Int, y: Int): Int = {
    if (y == 0) throw new ArithmeticException("Cannot divide by zero.") // 0나누기: Exception 날리기
    else x / y
  }

  // try & catch & finally keyword
  try {
    divide(10, 0)
  } catch {
    case e: ArithmeticException => println("Arithmetic problem: " + e.getMessage)
    case e: Exception => println("Error: " + e.getMessage)
  } finally {
    println("This will always be printed.")
  }

  // using Try class
  val result = Try(divide(10, 0))
  result match {
    case Success(value) => println(s"Result: $value")
    case Failure(exception) => println(s"Failed with exception: ${exception.getMessage}")
  }

  // custom Exception: Exception을 상속받아서 사용 가능, message를 받아야 한다.
  class MyCustomException(message: String) extends Exception(message)
  def myFunction(condition: Boolean): Unit = {
    if (condition) throw new MyCustomException("My custom error message.")
  }

  try {
    myFunction(true)
  } catch {
    case e: Exception => println("Error: " + e.getMessage)
  }
}
