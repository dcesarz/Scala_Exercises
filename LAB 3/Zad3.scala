import scala.annotation.tailrec

object Main2 extends App {
  def ciag(n: Int): Int = {
    @tailrec
    def fib(n: Int, m: Int, l: Int): Int = {
      if (n <= 0) l
      else fib(l - 1, m = m + l, l = m)
    }
    fib(n,1,1)
  }
  
}
