// Generics: 불특정
// class ClassName[T] ~ : 클래스에 대한 type을 설정할 수 있다. T는 사용자가 결정 가능
// Co-variance: A가 B타입보다 작은 경우, 작은 타입을 큰 타입에 넣을 수 있다.
// In-variance(변경 불가)
// Contra-variance(반대로 변경)

object Generics extends App {
  // Generic class
  class MyContainer[T](value: T) {
    def getContent: T = value
  }

  // Create instances of MyContainer with different types
  val intContainer = new MyContainer(42) // T: int로 전부 변경
  val stringContainer = new MyContainer("Hello, Scala!") // T: String으로 전부 변경

  val intValue: Int = intContainer.getContent
  println(intValue)
  val stringValue: String = stringContainer.getContent
  println(stringValue)

  // Generic method
  class MyList {
    def makeTuple[A, B](first: A, second: B): (A, B) = {
      (first, second)
    }
  }

  val myList = new MyList

  val intStringTuple = myList.makeTuple(42, "Hello")
  println(intStringTuple)
  val doubleBooleanTuple = myList.makeTuple(3.14, true)
  println(doubleBooleanTuple)

  class Animal
  class Dog extends Animal
  class Cat extends Animal

  // Covariance: Animal에 Dog 넣기
  class AnimalContainer1[+T](value: T)
  val dogContainer1: AnimalContainer1[Animal] = new AnimalContainer1[Dog](new Dog)

  // Invariance: 같은 것만 넣기
  class AnimalContainer2[T](value: T)
  val animalContainer2: AnimalContainer2[Animal] = new AnimalContainer2[Animal](new Animal)
  val dogContainer2: AnimalContainer2[Dog] = new AnimalContainer2[Dog](new Dog)

  // Contravariance: Dog에 Animal 넣기
  class AnimalContainer3[-T](value: T)
  val animalContainer3: AnimalContainer3[Dog] = new AnimalContainer3[Animal](new Animal)


  // Bounds Type: min~max를 설정함
  // Upper bounds: Animal의 서브타입도 가능
  class Container[T <: Animal](value: T) {
    // This container can hold animals or their subtypes
    def getAnimal: T = value
  }

  // Lower bounds: Dog의 슈퍼타입도 가능
  class PetContainer[T >: Dog](pet: T) {
    // This container can hold pets or their supertypes (e.g., Animal)
    def getPet: T = pet
  }

  val animalContainer = new Container(new Dog) // Dog: Animal 서브 타입
  println(animalContainer.getAnimal)
  val catContainer = new Container(new Cat) // Cat: Animal 서브 타입
  println(catContainer.getAnimal)

  val dogContainer = new PetContainer(new Dog)
  println(dogContainer.getPet)
  val animalPetContainer = new PetContainer(new Animal)
  println(animalPetContainer.getPet)
}
