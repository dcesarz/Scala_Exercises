import scala.annotation.tailrec

object Main extends App {
   def jestPierwsza(n: Int): Boolean = {
     @tailrec
      def helper(x: Int, i: Int): Boolean = {
        if(i < Math.sqrt(x))
        {
        if(x == 2 || x == 1 || x ==0) false
        else if(x % i == 0) false
        else helper(x, i+1)
        }
        else true
    }
    helper(n, 2)
  }
  print(jestPierwsza(97))
}
