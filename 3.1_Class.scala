// Class 1. Person
class Person(val name: String, age: Int) {
  // Class parameters name and age are used to initialize class members.

  // Overloading(오버로딩): 파라미터가 다른 동일한 이름의 함수
  def greet(): String = s"Hello, my name is $name and I am $age years old."
  def greet(name: String) = s"Hello, my name is ${this.name} and I am $age years old. Nice to meet you $name"

  // Constructor
  def this(name: String) = this(name, 40)
  def this() = this("Joon")
}

// Class 2. Car
class Car {
  // 필드: Car 클래스에서 공유하는 것
  var model: String = "modelY"
  var year: Int = 2023

  // Primary constructor
  def this(model: String, year: Int) = {
    this() // Call the primary constructor first
    this.model = model
    this.year = year
  }

  // Auxiliary constructor with only a name parameter
  def this(model: String) = {
    this() // Call the primary constructor first
    this.model = model
  }

  // Auxiliary constructor with only an age parameter
  def this(year: Int) = {
    this() // Call the primary constructor first
    this.year = year
  }

  def introduce(): Unit = {
    println(s"${this.model}(${this.year}) is starting...")
  }
}

// main
object OOP extends App {
  // Create instances of the Person class
  val person1 = new Person("Alice", 30)
  val person2 = new Person("Bob", 25)
  println(person1.name)

  // Use the greet() method
  println(person1.greet())
  println(person2.greet())
  println(person1.greet(name="Tom"))

  val person3 = new Person() // 파라미터 없음
  println(person3.greet()) // default: Jone, 40로 설정됨

  val car1 = new Car(model = "modelS", year = 2024)
  car1.introduce()
  val car2 = new Car(model = "model3")
  car2.introduce()
  val car3 = new Car(year = 2022)
  car3.introduce()
}
