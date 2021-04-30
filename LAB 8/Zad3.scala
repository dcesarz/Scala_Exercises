class Complex3{
    var re : Double = 0
    var im : Double = 0
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

object Complex3{
    def apply(re: Double, im: Double): Complex3 = {
        var c = new Complex3
        c.re = re
        c.im = im
        c
    }
}

object Zad3 extends App {
  val c1 = Complex3(re = 1, im = 2)
  print(c1)
  val c2 = Complex3(re = 1, im = -2)
  print(c2)
  val c3 = Complex3(re = 1, im = 0)
  print(c3)
  val c4 = Complex3(re = 4, im = -5)
  print(c4)
}