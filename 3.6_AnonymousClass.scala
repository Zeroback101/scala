// 익명 클래스
// 추상 클래스나 trait을 인스턴스화 할때나 클래스를 한번만 사용할 경우에 사용한다.

object AnonymousClass extends App {
  // 1. 추상 클래스
  abstract class Swimmer {
    def swim: Unit
  }

  val swimmer = new Swimmer { // Swimmer를 인스턴스화 불가능하므로 메소드를 오버라이딩 해야함
    override def swim: Unit = println("Swimming ...")
  }
  swimmer.swim


  // 2. trait
  trait Greeter(val name: String) {
    def greet(target: String): String
  }

  // Create an instance of the Greeter trait using an anonymous class
  val greeter = new Greeter("Joon") { // 인스턴스화는 가능. greet을 오버라이딩
    def greet(target: String): String = s"Hello, $name greets to $target!"
  }

  // Use the greeter to greet someone
  val greeting = greeter.greet("Alice")
  println(greeting)
}
