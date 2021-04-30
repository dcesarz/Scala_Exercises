

object lab7 {
  def main(args: Array[String]): Unit = {
    val testTxtSource1 = scala.io.Source.fromFile("data/liczby.txt")
    val liczby = testTxtSource1.getLines.toList
    val testTxtSource2 = scala.io.Source.fromFile("data/osoby.txt")
    val osoby = testTxtSource2.getLines.toList
    val testTxtSource3 = scala.io.Source.fromFile("data/ogniem_i_mieczem.txt")
    val oim = testTxtSource3.getLines.toList
    val testTxtSource4 = scala.io.Source.fromFile("data/liczby2.txt")
    val liczby2 = testTxtSource4.getLines.map(a => a.toInt).toSeq
    testTxtSource1.close()
    testTxtSource2.close()
    testTxtSource3.close()
    testTxtSource4.close()
    println(liczby)
    println(zad1(liczby))
    println(osoby)
    println(zad2(osoby))
    println(oim)
    histogram(oim, 20)
    println(liczby2)
    println(maxSubSeqs(liczby2))
  }

  def zad1[A](seq: Seq[A]): Int = {
    seq.foldLeft(0) { (acc, result) =>
      if (result.toString.map(a => a.asDigit).sliding(2).foldLeft(true) {
        (acc, result) =>
          if (result(0) <= result(1)) acc else false
      }) acc + 1 else acc
    }
  }

  def zad2(list: List[String]): List[String] = {
    list.map(c => c.split(" ",2)).
      sortBy(c => -c.head.distinct.length).
      sortBy(c => c(1).length).
      map(a => a.head + " " + a(1))
  }

  def histogram(list: List[String], max: Int): Unit = {
    list.foldLeft(""){
      (acc, result) =>
        acc + " " + result
    }.toLowerCase.
      filter(a => a.isLetter).
      groupBy(identity).
      toList.
      foreach(a =>
        println(a._1 + ": " + ("*" * Seq(a._2.length, max).min) + "\n")
    )
    ()
  }

  def maxSubSeqs(seq: Seq[Int]): Unit = {
    val indices_uncut = seq.sliding(2).
      zipWithIndex.
      map( a => List(a._1.head, a._1(1), a._2)).
      filter{
        case List(a, b, _) => {
         a <= b
       }
      }.map(c => c(2))
    val indices = indices_uncut.sliding(2).foldLeft(List(0)){
      (acc, result) => {
        if(result.head < result(1) + 1) acc :: List(acc.tail + 1)
      }
    }
  }

}
