object Zad1 extends App {
def sum(l: List[Option[Int]]): Option[Int] = {
  def helper(l1: List[Option[Int]], sum: Int): Option[Int] = {
    l1 match{
      case List() => Some(sum)
      case None => helper(l1
      case Some(lH)::lT => helper(lT, (sum + lH))
    }
  }
  def cut(l1: List[Option[Int]]): List[Option[Int]] = {
    l1 match{
      case List() => List()
      case Some(lH)::lT => helper(lT, (sum + lH))
    }
  } 
  helper(l, 0)
}
print(sum(List(Some(1),Some(2), None, Some(3), Some(4), Some(5))))
}
