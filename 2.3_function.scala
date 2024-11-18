object Function extends App {
  def add(a: Int, b: Int): Int = {
    a + b
  }
  println(add(1, 2))

  // concise version
  // equal sign(=) 다음에는 function body가 나온다.
  def add2(a:Int, b: Int): Int = a + b
  println(add(2, 3))

  // function types(assign anonymous function to val)
  // fat arrow(=>) 다음에는 function type이 나온다.
  val subtract = (a: Int, b: Int) => a - b
  val result = subtract(10, 3)
  println(result)

  // Key diff between = and =>
  // = : comes function body(method definitions)
  // =>(fat arrow) : comes function type(function literal)

  // higher order function
  // operation이라는 익명의 함수를 인자로 받는다.
  def operateOnNumbers(a: Int, b: Int, operation: (Int, Int) => Int): Int = {
    operation(a, b)
  }
  val outputSum = operateOnNumbers(2, 3, add)
  println(outputSum)

  // anonymous function(function literals)
  // (x, y) => x * y: 익명의 함수, fat arrow 사용
  val result1 = operateOnNumbers(3, 4, (x, y) => x * y)
  println(result1)

  // nested function
  // 함수 안에 함수
  def factorial(n: Int): Int = {
    def iter(x: Int, result: Int): Int = {
      if (x <= 0) result
      else iter(x - 1, x * result)
    }
    iter(n, 1)
  }
  println(factorial(3))

  // default parameters and named arguments, String interpolation ${XXX}
  // default 파라미터를 설정하여 인자를 넘기지 않아도 디폴트 값으로 설정된다.
  // String interpolation ${XXX} -> 변수를 출력하고 싶을 때 사용
  def greet(name: String, greeting: String = "Hello"): String = s"${greeting}, $name!"
  println(greet(name = "Alice", greeting = "Hi"))
  println(greet(name = "Bob"))

  // varargs(variable number of arguments)
  // *: 여러개의 변수를 sequence로 보내는 경우 사용
  def totalSum(numbers: Int*): Int = numbers.sum
  println(totalSum(1, 2, 3, 4))

  // String을 여러개 넘겨서 붙이는 경우 사용
  def concatenate(strings: String*): String = {
    strings.mkString
  }
  println(concatenate("Hello", "Concat", "World", "!"))

  def findMax(numbers: Int*): Int = {
    numbers.max
  }
  println(findMax(1, 2, 3, 10))

  // <-: string seq를 하나씩 넣는 경우 사용
  def printAll(strings: String*): Unit = {
    for (str <- strings) {
      println(str)
    }
  }
  printAll("Scala", "is", "fun")

  // foreach(): 앞의 리스트가 하나하나 분리하여 넘겨준다.
  def greet2(greeting: String, names: String*): Unit = {
    names.foreach(name => println(s"$greeting $name"))
  }
  greet2("Hello", "Alice", "Bob", "Charlie")

  // partial function: PartialFunction[INPUT_TYPE, OUTPUT_TYPE]
  // Partial로 분리하는 것: 첫번째 스트링과 두번째 스트링을 일대일 매칭한다.
  val handleStrings: PartialFunction[String, String] = {
    case "Scala" => "A great language"
    case "Java" => "A classic language"
  }
  println(handleStrings("Scala"))
//  println(handleStrings("Python")) // scala.MatchError: Python (of class java.lang.String)

  // check if partial function is defined
  if (handleStrings.isDefinedAt("Ruby")) {
    println(handleStrings("Ruby"))
  } else {
    println("No information about Ruby")
  }

  case class Person(name: String, age: Int)
  case class Product(name: String, price: Double)

  // Any: 아무거나 넣어도 상관없음.
  val handleEntities: PartialFunction[Any, String] = {
    case Person(name, _) => s"This is a person named $name."
    case Product(name, price) => s"This is a product named $name($$ $price)"
  }
  println(handleEntities(Person("Alice", 30)))
  println(handleEntities(Product("Book", 10.99)))
}
