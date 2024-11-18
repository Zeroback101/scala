object StaticClass extends App {
  // class: name, age를 인자로 받고, greet 함수가 정의되어 있음.
  class Person(name: String, age: Int) {
    def greet(): String = s"Hello, my name is $name and I am $age years old."
  }

  // companion object: 정적 함수와, 유틸리티 함수를 정의할 수 있다.
  object Person {
    // Factory method to create Person instance
    // new Person() 대신 Person()을 사용할 수 있도록 한다.
    def apply(name: String, age: Int): Person = new Person(name, age)

    // Static utility method
    def isValidAge(age: Int): Boolean = age >= 0
  }

  val person = Person("Alice", 30)

  // Accessing the greet method and utility method
  println(person.greet()) // Output: Hello, my name is Alice and I am 30 years old.
  println(Person.isValidAge(25)) // Output: true
}
