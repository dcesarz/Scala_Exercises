class Complex5(val re: Double, val im: Double){
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
    def +(that: Complex5): Complex5 = new Complex5(this.re + that.re, this.im + that.im)
    def -(that: Complex5): Complex5 = new Complex5(this.re - that.re, this.im - that.im)
    def *(that: Complex5): Complex5 = new Complex5(((this.re * that.re)-(this.im*that.im)), (this.im * that.re)+(this.re*that.im))
    def /(that: Complex5): Complex5 = {
        print(that)
        //require( (that.re*that.re)+(that.im*that.im) (_ >= 0), "List contains negative numbers")
        new Complex5(((this.re * that.re)-(this.im*that.im), (this.im * that.re)+(this.re*that.im))/((that.re*that.re)+(that.im*that.im)))
    }
}

object Complex5{
    def apply(re: Double, im: Double): Complex5 = {
        var c = new Complex5(re, im)
        c
    }
}

object Zad5 extends App {
  val c1 = Complex5(re = 1, im = 2)
  print(c1)
  val c2 = Complex5(re = 1, im = -2)
  print(c2)
  val c3 = Complex5(re = 1, im = 0)
  print(c3)
  val c4 = Complex5(re = 4, im = -5)
  print(c4)
  print(c1*c4)
}