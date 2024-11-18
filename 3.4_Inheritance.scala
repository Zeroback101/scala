// Inheritance
// public(default), protected는 상속 가능, overriding 가능
// 자식 클래스에서 부모에 접근할 때에는 super 키워드를 사용한다.
// 추상 클래스: 하나만 상속 가능 -> 인스턴스화 불가능, 추상 메소드를 반드시 자식이 정의해야 한다.
// Traits: 여러개 상속 가능 -> 

object Inheritance extends App {
  // 1. Define a superclass
  class Animal(name: String) {
    val species = "Animal"
    def eat(food: String): Unit = println(s"${this.species} eats ${food}")
    def speak(): Unit = println(s"$name makes a sound")
  }

  trait Swimmer {
    def swim(): Unit
  }

  // Define a subclass
  // 상속을 할 경우, class parameter를 반드시 작성해야 한다.
  // trait은 with 키워드와 함께 사용
  class Dog(name: String) extends Animal(name) with Swimmer {
    // 오버라이딩 가능
    override val species = "Dog"
    override def speak(): Unit = println(s"$name barks")
    // trait에서 추상 메소드 정의
    def swim(): Unit = println(s"${name} can swim")
    override def eat(food: String): Unit = {
      // parent의 값에 접근: super
      super.eat(food)
    }
  }

  class Cat(name: String) extends Swimmer {
    def swim(): Unit = println(s"${name} cannot swim")
  }

  // Create instances
  val animal = new Animal("Generic Animal")
  val dog = new Dog("Rex")
  val cat = new Cat("Kitty")

  // Calling methods
  animal.speak() // Output: Generic Animal makes a sound
  dog.speak() // Output: Rex barks
  dog.eat("food")


  // 2. abstract class 정의 -> 추상 메소드만 갖는다.
  abstract class Person(name: String) {
    def walk(): Unit
  }

  trait Runner {
    def run(): Unit
  }

  class Tom(name: String) extends Person(name) with Swimmer with Runner {
    override def walk(): Unit = println(s"${name} can walk")
    def swim(): Unit = println(s"${name} can swim")
    def run(): Unit = println(s"${name} can run")
  }

  val tom = new Tom("tom")
  tom.walk()
  tom.swim()
  tom.run()
}
