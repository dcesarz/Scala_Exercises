import akka.actor._
import scala.io.StdIn

case class Wstaw2(n: Int)
case class Usuń(n: Int)
case class Pusto(n: Int)


class Węzeł2 extends Actor {

  def receive: Receive = {
    case Wstaw2(x: Int) =>
      context.become(korzeń(x))
    case _ =>
      println(s"${self.path.name}: UNKNOWN MESSAGE")
  }

  def korzeń(wartość: Int): Receive = {
    ???
  }

  def zPotomkami(wartość: Int, potomkowie: Set[ActorRef]): Receive = {
    ???
  }

}

class Nadzorca extends Actor {
  def receive: Receive = {
    case Wstaw2(x: Int) = 
      val worker = context.actor(Props[Węzeł2](), s"worker$x")
      worker ! Wstaw2(x)
      context.become(stan(Set(x)))
    case _ => 
      println(s"${self.path.name}: UNKNOWN MESSAGE")    
  }

  def stan(znane: Set[Int]): Receive = {
    ???
  }
}

object Zad2 extends App {
  val system = ActorSystem("system")
  val nadzorca = system.actorOf(Props[Nadzorca], "nadzorca")
    println("**Naciśnij ENTER żeby zakończyć**")
  StdIn.readLine()
  system.terminate()

}
