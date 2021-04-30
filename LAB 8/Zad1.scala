class Complex(val re: Double = 0, val im: Double = 0) {
  override def toString: String =
    s"($re, $im)"
}
object Zad1 extends App {
  val c1 = new Complex(re = 1, im = 2)
  print(c1)
}