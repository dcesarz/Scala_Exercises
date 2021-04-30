object Zad1 extends App {
  println("Podaj wartość 1:")
  var x = io.StdIn.readInt()
  print("Podaj wartość 2: ")
  var y = io.StdIn.readInt()
  var r = 0
  if (x == 0) {
    println(y)
  }
  else if (y == 0) {
    println(x)
  }
  else {
    while ((x != 0 ) && (y != 0)){
      r = x % y
      x = y
      y = r
    }
    if(x > y) println(x) else println(y)
  }
}
