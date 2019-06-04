package playground


object Solution extends App {

  def solution(a: Array[Int]): Int = {

    val sorted = a.sorted.distinct
    val naturals = sorted.filter(_ >= 0)

    if (naturals isEmpty) return 1

    val max = naturals.max
    val length = naturals.length

    if (length == 0) 1

    else if (max < 0) 1

    else if (length == 1)
      if (max != 1)  1
      else 2

    else {
      val plusOneArray = naturals.map(n => n + 1)

      for (i <- 0 until (length - 1)) {
        if (plusOneArray(i) != naturals(i + 1)) return plusOneArray(i)
      }

      if (plusOneArray.max > 0) plusOneArray.max
      else 1
    }




  }

  val array1 = Array(2, 3, 5, 6, 4)
  val array2 = Array(1, 5, 7, 6, 4)
  val array3 = Array(2, -3)
  val array4 = Array(0, 1, 2, 3, 4)
  val array5 = Array(-2, -3, -5, -6, -4)

  println("Solution for " + array1.foreach(println) + " is: " + solution(array1))
  println()
  println("Solution for " + array2.foreach(println) + " is: " + solution(array2))
  println()
  println("Solution for " + array3.foreach(println) + " is: " + solution(array3))
  println()
  println("Solution for " + array4.foreach(println) + " is: " + solution(array4))
  println()
  println("Solution for " + array5.foreach(println) + " is: " + solution(array5))


}
