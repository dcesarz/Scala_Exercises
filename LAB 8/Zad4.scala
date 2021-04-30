class Complex4(val re: Double, val im: Double){
    // var re : Double = 0
    // var im : Double = 0
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
    def +(that: Complex4): Complex4 = new Complex4(this.re + that.re, this.im + that.im)
    def -(that: Complex4): Complex4 = new Complex4(this.re - that.re, this.im - that.im)
    def *(that: Complex4): Complex4 = new Complex4(((this.re * that.re)-(this.im*that.im)), (this.im * that.re)+(this.re*that.im))
}

object Complex4{
    def apply(re: Double, im: Double): Complex4 = {
        var c = new Complex4(re, im)
        c
    }
}

object Zad4 extends App {
  val c1 = Complex4(re = 1, im = 2)
  print(c1)
  val c2 = Complex4(re = 1, im = -2)
  print(c2)
  val c3 = Complex4(re = 1, im = 0)
  print(c3)
  val c4 = Complex4(re = 4, im = -5)
  print(c4)
  print(c1*c4)
}