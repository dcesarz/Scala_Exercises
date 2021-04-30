object Main extends App {
   def jestPalindromem(tab: Array[Int]): Boolean = {
    def helper(i: Int): Boolean = {
        if (i == tab.size/2) true
        else if (tab(i) == tab(tab.size-1-i)) helper(i+1)
        else false
    }
    helper(0)
   }
  val tablica1: Array[Int] = Array(1,2,3,2,1)
  val tablica2: Array[Int] = Array(1,2,3,3,3)
  println(strlength(x))
}
