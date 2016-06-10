package single

import math.Ordering

object MergeSortImpl {
  def MergeSort(l: List[Int]): List[Int] = {
    def Merge(l1: List[Int], l2: List[Int]): List[Int] = {
      if (l1.isEmpty) l2
      else if (l2.isEmpty) l1
      else if (l1.head <= l2.head) l1.head :: Merge(l1.tail, l2)
      else l2.head :: Merge(l1, l2.tail)
    }

    val listSize = l.size
    val halfSize = listSize/2

    if (listSize == 1) l
    else {
      val firstHalf = MergeSort(l take halfSize)
      val secondHalf = MergeSort(l drop halfSize)

      Merge(firstHalf, secondHalf)
    }
  }

  /**
    * Implementation using Pair and Pattern matching on pair
    */
  def MergeSort_2(l: List[Int]): List[Int] = {
    def Merge(l1: List[Int], l2: List[Int]): List[Int] = (l1, l2) match {
      case (Nil, `l2`) => l2
      case (`l1`, Nil) => l1
      case (l1Head :: l1Tail, l2Head :: l2Tail) =>
        if (l1Head <= l2Head) l1Head :: Merge(l1Tail, l2)
        else l2Head :: Merge(l1, l2Tail)
    }

    val listSize = l.size
    val halfSize = listSize/2

    if (listSize == 1) l
    else {
      val (firstHalf, secondHalf) = l splitAt halfSize

      Merge(MergeSort_2(firstHalf), MergeSort_2(secondHalf))
    }
  }

  /**
    * Implementation using Pair and Pattern matching on pair
    */
  def MergeSort_generic[T](l: List[T])(lt:(T,T) => Boolean): List[T] = {
    def Merge(l1: List[T], l2: List[T]): List[T] = (l1, l2) match {
      case (Nil, `l2`) => l2
      case (`l1`, Nil) => l1
      case (l1Head :: l1Tail, l2Head :: l2Tail) =>
        if (lt(l1Head, l2Head)) l1Head :: Merge(l1Tail, l2)
        else l2Head :: Merge(l1, l2Tail)
    }

    val listSize = l.size
    val halfSize = listSize/2

    if (listSize == 1) l
    else {
      val firstHalf = MergeSort_generic(l take halfSize)(lt)
      val secondHalf = MergeSort_generic(l drop halfSize)(lt)

      Merge(firstHalf, secondHalf)
    }
  }

  def MergeSort_with_Ordering[T](l: List[T])(ord: Ordering[T]): List[T] = {
    def Merge(l1: List[T], l2: List[T]): List[T] = (l1, l2) match {
      case (Nil, `l2`) => l2
      case (`l1`, Nil) => l1
      case (l1Head :: l1Tail, l2Head :: l2Tail) =>
        if (ord.lt(l1Head, l2Head)) l1Head :: Merge(l1Tail, l2)
        else l2Head :: Merge(l1, l2Tail)
    }

    val listSize = l.size
    val halfSize = listSize/2

    if (listSize == 1) l
    else {
      val firstHalf = MergeSort_with_Ordering(l take halfSize)(ord)
      val secondHalf = MergeSort_with_Ordering(l drop halfSize)(ord)

      Merge(firstHalf, secondHalf)
    }
  }

  def testMergeSort(sortedList: List[Int]) = {
    println(sortedList)

    assert(sortedList.head == -4)
    assert(sortedList.tail.head == 1)
    assert(sortedList(5) == 10)
  }

  def main(args: Array[String]): Unit = {
    val list = List(1, 2, -4, 5, 6, 10)

    testMergeSort(MergeSort(list))
    testMergeSort(MergeSort_2(list))

    // Call Generic Merge sort for integers
    testMergeSort(MergeSort_generic(list)((x: Int, y: Int) => x < y))

    // We can also call generic merge sort for integers or any other type but we need to pass comparator
    // Example in case of string, we can call str1, str2 => str1.compareTo(str2) < 0

    // Call Generic Merge sort for integers
    testMergeSort(MergeSort_with_Ordering(list)(Ordering.Int))
  }
}