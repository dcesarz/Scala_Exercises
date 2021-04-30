object Zad2 extends App {
  println("Podaj wartość")
  var x = io.StdIn.readInt()
  var y = 2
  while(y < ((x/2) + 1))
  {
    if(x % y == 0)
    {
      println("liczba nie jest pierwsza")
      y = x
    }
    else
    {
      y += 1
    }
  }
  if(y != x){
    println("liczba jest pierwsza"
    )
  }
}
