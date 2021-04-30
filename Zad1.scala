object Main extends App {
  
  def strlength(str: String): Int = {
   if(str == "")
   {
     return 0
   }
   else
   {
     return 1 + strlength(str.tail)
   }
  }

  println("Podaj string")
  var x = io.StdIn.readLine()
  println(strlength(x))
}
