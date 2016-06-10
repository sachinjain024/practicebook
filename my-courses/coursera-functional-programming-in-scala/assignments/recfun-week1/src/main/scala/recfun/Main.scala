package recfun
import common._

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    println("Testing parenthesis balancing")
    assert(balance("(Sachin is learning (scala) and (spark))".toList))
    assert(!balance("(Invalid))(expression)".toList))
    assert(balance("".toList))
    assert(balance("()()".toList))
    assert(!balance("{())}{()}".toList))

    println("Testing coin change algorithm")
    assert(countChange(4, List(1)) == 1)
    assert(countChange(4, List(1, 2)) == 3)
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (r == 0 || c == 0 || r == c) 1
    else pascal(c, r-1) + pascal(c-1, r-1)

  /**
   * Exercise 2
    * http://stackoverflow.com/questions/37226053/how-to-calculate-a-value-based-on-certain-conditions-in-scala
   */
  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def isValid(newChars: List[Char], difference: Int): Boolean = {
      if (newChars.isEmpty) difference == 0
      else if (difference < 0) false
      else {
        val newDifference = newChars.head match {
          case '(' => difference + 1
          case ')' => difference - 1
          case _   => difference
        }

        isValid(newChars.tail, newDifference)
      }
    }

    isValid(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money < 0) 0
    else if (money == 0) 1
    else if (coins.isEmpty) 0
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}
