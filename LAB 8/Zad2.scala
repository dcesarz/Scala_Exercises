class Complex2(val re: Double = 0, val im: Double = 0) {
    override def toString: String = {
        if(this.im > 0)
            {
            s"$re + $im i \n"
            }
        else if(im < 0)
            {    
            s"$re - ${-im} i \n"    
            }
        else{
            s"$re \n"
            }
    }
    
}
object Zad2 extends App {
  val c1 = new Complex2(re = 1, im = 2)
  print(c1)
  val c2 = new Complex2(re = 1, im = -2)
  print(c2)
  val c3 = new Complex2(re = 1, im = 0)
  print(c3)
}