object lab6 {
  def main(args: Array[String]): Unit = {
    val seq = Seq(1, 2, 1, 1, 5)
    val seq1 = Seq(1, 2, 3, 5, 8)
    val seq2 = Seq(2, 3, 4, 5, 6)
    val set = Set(-3, 0, 1, 2, 5, 6)
    val set1 = Set(-3, 4, 1, 0, 3, 7, 5, 2)
    val zones: Seq[String] = java.util.TimeZone.getAvailableIDs.toSeq
    val code = Seq(1, 3, 2, 2, 4, 5)
    val move = Seq(2, 1, 2, 4, 7, 2)
    println(seq)
    println(indices(seq, 1))
    println(minNotContained(set))
    println(minNotContained(set1))
    println(swap(seq1))
    println(zones)
    println(zad4(zones))
    println(score(code)(move))
  }
  def indices[A](seq: Seq[A], el: A): Set[Int] = {
    seq.zipWithIndex.filter(_._1 == el).map{case (_,b) => b}.toSet
  }

  def minNotContained(set: Set[Int]): Int = {
    set.toSeq.sorted.foldLeft(0){
      (acc, item) => if (acc == item) item+1 else acc
    }
  }

  def minNotContainedFancy(set: Set[Int]): Int = {
    (0 to set.max).toSet.diff(set).min
  }

  def swap[A](seq: Seq[A]): Seq[A] = {
    seq.sliding(2,2).flatMap{a => a.reverse}.toSeq
  }

  def zad4(seq: Seq[String]): Seq[String] = {
    seq.flatMap(a => a.split("/"))
      .grouped(2)
      .toSeq
      .filter(_(1) == "Europe")
      .map(a => a.head)
      .sorted
      .sortBy(_.length)
  }

  def score(code: Seq[Int])(move: Seq[Int]): (Int, Int) = {
    val black = code.zip(move).count { case (a, b) => a == b }
    val white = code.intersect(move).length
    (black, if(white > 0) white - black else 0)
  }


}
