object lab5 {
  def subseq_improved_by_intellij[A](seq: Seq[A], begIdx: Int, endIdx: Int): Seq[A] = {
    seq.slice(begIdx, begIdx + endIdx)
  }

  def main(args: Array[String]): Unit = {
    val seq = Seq(1, 2, 1, 1, 5)
    val seq1 = Seq(1, 2, 3, 5, 8)
    println(seq)
    println(subseq(seq, 1, 3))
    println(remElems(seq, 1))
    println(isOrdered(seq)(_ < _))
    println(isOrdered(seq1)(_ < _))
    println(seq.groupBy(identity))
    println(freq(seq))
    println(deStutter(seq))
    println(diff(seq, seq1))
  }

  def subseq[A](seq: Seq[A], begIdx: Int, endIdx: Int): Seq[A] = {
    seq.drop(begIdx).take(endIdx)
  }

  def remElems[A](seq: Seq[A], k: Int): Seq[A] = {
    // first, zip with index. filter by second element of the tuple. Delete second element of tuple with map.
    seq.zipWithIndex.filter(_._2 != k).map { case (a, _) => a }
  }

  def isOrdered[A](seq: Seq[A])(leq: (A, A) => Boolean): Boolean = {
    //we group the list in pairs of two, we check for every subsequence if leq holds up, then we do and for all elems
    seq.sliding(2).map(s => leq(s(0), s(1))).foldLeft(true) {
      (a, b) => a && b
    }
  }

  def freq[A](seq: Seq[A]): Seq[(A, Int)] = {
    seq.groupBy{identity}.mapValues(_.size).toSeq
  }

  def deStutter[A](seq: Seq[A]): Seq[A] = {
    seq.foldLeft(Seq[A]()){(acc, item) =>
      if (acc.isEmpty || item != acc.last) acc ++ Seq(item) else acc
    }
  }

  def diff[A](seq1: Seq[A], seq2: Seq[A]): Seq[A] = {
    seq1.zip(seq2).filter{case (a,b) => a != b}.map{
      case (a,b) => a
    }
  }

}

