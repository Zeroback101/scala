object StringManipulation extends App {
  // String Concatenation
  val firstName = "John"
  val lastName = "Doe"
  val fullName = firstName + " " + lastName
  println(fullName) // Output: John Doe

  // String Interpolation
  // s: Interpolates values into a string using ${}
  val age = 30
  val message = s"My age is $age"
  println(message) // Output: My age is 30

  // f: Allows you to format strings using placeholders -> String의 넘버를 채워 넣는 경우 사용
  val pi = 3.14159
  val formatted = f"Pi is approximately $pi%4.2f" // 전체 4자리, 소수점 이하 2자리
  println(formatted) // Output: Pi is approximately _3.14

  // raw: Treats the string content as raw, without interpreting escape sequences
  val rawStr = raw"This is a \n raw string."
  println(rawStr) // Output: This is a \n raw string.

  // String Methods
  // 1. length: 길이
  val text = "Scala is fun!"
  val length = text.length
  println(length) // Output: 13

  // 2. charAt(index: Int): 인덱스 위치의 문자 리턴
  val char = text.charAt(0)
  println(char) // Output: S

  // 3. substring(start: Int, end: Int): Extracts a substring from the given string,
  //    starting from the start index (inclusive) to the end index (exclusive).
  val subStr = text.substring(0, 5)
  println(subStr) // Output: Scala

  // 4. 대문자, 소문자
  val upper = text.toUpperCase
  val lower = text.toLowerCase
  println(upper) // Output: SCALA IS FUN!
  println(lower) // Output: scala is fun!

  // 5. split(separator: String): Splits a string into an array of substrings based on the specified separator.
  val words = text.split(" ")
  println(words.mkString(", ")) // Output: Scala, is, fun!

  // 6. startsWith(prefix: String) and endsWith(suffix: String): 시작하고 끝나는 String
  val startsWithScala = text.startsWith("Scala")
  val endsWithFun = text.endsWith("fun!")
  println(startsWithScala) // Output: true
  println(endsWithFun) // Output: true

  // 7. contains(substring: String): Checks if a string contains the specified substring.
  val str1 = "Hello, Scala!"
  val containsScala = str1.contains("Scala")
  println(containsScala) // Output: true

  // 8. trim: 빈공간 제거
  val str2 = "   Scala is fun!   "
  val trimmed = str2.trim
  println(trimmed) // Output: "Scala is fun!"

  // 9. indexOf(substring: String) and lastIndexOf(substring: String): 문자열이 나오는 인덱스
  val str3 = "Hello, Scala, and Scala is fun!"
  val firstIndex = str3.indexOf("Scala")
  println(firstIndex) // Output 7
  val lastIndex = str3.lastIndexOf("Scala")
  println(lastIndex) // Output 18

  // 10. replace(oldStr: String, newStr: String):
  //    Replaces all occurrences of oldStr with newStr in the string.
  val str4 = "Hello, Scala!"
  val replaced = str4.replace("Scala", "Java")
  println(replaced) // "Hello, Java!"
}
