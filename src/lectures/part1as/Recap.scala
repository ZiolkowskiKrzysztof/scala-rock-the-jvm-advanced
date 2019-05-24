package lectures.part1as

import scala.annotation.tailrec

object Recap extends App {

  val aCondition: Boolean = false
  val aConditionVal = if (aCondition) 42 else 65
  // instructions vs expressions

  // compilers infers types for us
  val aCodeBlock = {
    if (aCondition) 54
    56
  }

  // Unit
  val theUnit = println("Hello Scala")

  // functions
  def aFunction(x: Int): Int = x + 2

  // recursion: stack and tail
  @tailrec
  def factorial(n: Int, acc: Int): Int =
    if (n <= 0) acc
    else factorial(n - 1, n * acc)

  // object-orientation programming
  class Animal
  class Dog extends Animal
  val aDog: Animal = new Dog // subtyping polymorphism

  trait Carnivore {
    def eat(a: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override def eat(a: Animal): Unit = println("crunch")
  }

  // method notations
  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog  // natural language

  // anonymous classes
  val aCarnivore = new Carnivore {
    override def eat(a: Animal): Unit = println("roar")
  }

  // generics
  abstract class MyList[+A] // variance and variance problems in THIS course
  // singleton objects and companions
  object MyList

  // case classes
  case class Persona(name: String, age: Int)

  // exceptions and try/catch/finally

  val throwsExceptions = throw new RuntimeException // Nothing
  val aPotentialFailure = try {
    throw new RuntimeException
  } catch {
    case e: Exception => "I caught an exception"
  } finally {
    println("some logs")
  }

  // packaging and imports

  // functional programming
  val incrementer = new Function1[Int, Int] {
    override def apply(x: Int): Int = x + 1
  }

  incrementer(1)

  val anonymousIncrementer = (x: Int) => x + 1
  List(1, 2, 3).map(anonymousIncrementer) // HIGH ORDER FUNCTION

  // map, flatMap, filter

  // for-comprehension
  val pairs = for {
    num <- List(1, 2, 3)  // if condition
    char <- List('a', 'b', 'c')
  } yield num + "-" + char

  // Scala collections: Seqs, Arrays, Lists, Vectors, Maps, Tuples
  val aMap = Map(
    "Daniel" -> 789,
    "Jim" -> 555
  )

  // "collections": Option, Try
  val anOption = Some(2)

  // pattern matching
  val x = 2
  val order = x match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => x + "th"
  }

  /*
    val bob = Person("Bob", 22)
    val greeting = bob match {
      case Person(n, _) => s"Hi, my name is $n"
    }
   */

  // all the patterns

}
