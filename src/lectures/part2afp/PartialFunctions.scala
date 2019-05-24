package lectures.part2afp

object PartialFunctions extends App {

  val aFunction = (x: Int) => x + 1 // Function1[Int, Int] === Int => Int

  val aFussyFunction = (x: Int) =>
    if (x == 1) 52
    else if (x == 2) 56
    else if (x == 5) 900
    else throw new FunctionNotApplicableException

  class FunctionNotApplicableException extends RuntimeException

  val aNicerFussyFunction = (x: Int) => x match {
    case 1 => 52
    case 2 => 56
    case 5 => 900
  }

  val aPartialFunction: PartialFunction[Int, Int] = {
    case 1 => 52
    case 2 => 56
    case 5 => 900
  }

  println(aPartialFunction(5))

  // PF utilities
  println(aPartialFunction.isDefinedAt(57))

  // lift
  val lifted = aPartialFunction.lift
  println(lifted(2))
  println(lifted(22))

  val pfChain = aPartialFunction.orElse[Int, Int] {
    case 45 => 67
  }

  println(pfChain(2))
  println(pfChain(45))

  // PF extend normal functions

  val aTotalFunction: Int => Int = {
    case 1 => 99
  }

  // HOF accept partial functions as well
  val aMappedList = List(1, 2, 3).map {
    case 1 => 42
    case 2 => 82
    case 3 => 5000
  }

  println(aMappedList)

  /*
    NOTE: PF can only have ONE parameter type
   */

  /**
    * Excercises
    *
    * 1. construct a PF instance yourself (anonymous class)
    * 2. dumb chatbot as a PF
    */

  val aManualFussyFunction = new PartialFunction[Int, Int] {
    override def apply(x: Int): Int = x match {
      case 1 => 42
      case 2 => 56
      case 5 => 900
    }

    override def isDefinedAt(x: Int): Boolean =
      x == 1 || x == 2 || x == 5
  }

  val chatbot: PartialFunction[String, String] = {
    case "hello" => "Hi"
    case "goodbye" => "Bye"
    case "mom" => "Unable to find your phone"
  }



  scala.io.Source.stdin.getLines().map(chatbot).foreach(println)


}
