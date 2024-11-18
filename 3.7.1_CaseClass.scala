import java.io.{ObjectInputStream, ObjectOutputStream, ByteArrayInputStream, ByteArrayOutputStream}
import scala.util.Try

// case class
// 클래스를 쉽게 만들 수 있다.
// immutability: 인스턴스화 하면 변경 불가능
// automatic equals and hashcode를 value만 같으면 자동으로 만들어준다.
// 패턴 매칭 가능
// copy method 가능(클래스 파라미터에 오버라이딩 가능)
// toString
// companion Object: 이름은 같은 object
// serializable: 가장 중요함. 분산 처리에 중요함.

object CaseClass extends App {
  case class Person(name: String, age: Int)

  // Creating instances of the case class
  // companion이므로 new생성자 사용 안해도 됨. 
  // 변수에 바로 접근 가능: alice.name 등을 사용해도 출력된다.
  val alice = Person("Alice", 30)
  println(alice) // Person(Alice, 30)으로 출력
  val alice2 = Person("Alice", 30)
  // Equals(value에 접근) and Hash code
  println(alice == alice2)

  // no new keyword
  val bob = Person("Bob", 25)

  // Pattern matching on case class instances
  alice2 match {
    case Person("Alice", age) => println(s"Hello, Alice! Your age is $age")
    case _ => println("Unknown person")
  }

  // Using the copy method to create a modified instance
  val olderAlice = alice.copy(age = 31)
  println(olderAlice)
  // output Person(Alice,31)

  // Define a case class
  case class Point(x: Int, y: Int)

  // Create an instance of the case class
  val point = Point(5, 10)

  // Serialize the case class instance to a byte array
  val serializedObject = serialize(point)

  // Deserialize the byte array back into an object
  val deserializedObject = deserialize(serializedObject)

  // Check if deserialization was successful
  deserializedObject match {
    // Some represents may or may not exists
    case Some(p: Point) =>
      println(s"Deserialized point: $p")
    case _ =>
      println("Deserialization failed.")
  }

  def serialize(obj: Serializable): Array[Byte] = {
    val byteArrayOutputStream = new ByteArrayOutputStream()
    val objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)
    objectOutputStream.writeObject(obj)
    objectOutputStream.close()
    byteArrayOutputStream.toByteArray
  }

  def deserialize(bytes: Array[Byte]): Option[Serializable] = {
    Try {
      val byteArrayInputStream = new ByteArrayInputStream(bytes)
      val objectInputStream = new ObjectInputStream(byteArrayInputStream)
      val obj = objectInputStream.readObject()
      byteArrayInputStream.close()
      obj.asInstanceOf[Serializable]
    }.toOption
  }

  // Option[T]
  val someTest: Option[Int] = Some(42)
  println(someTest)
  val nonTest: Option[Int] = None
  println(nonTest)
}
