import akka.actor._
import scala.io.StdIn

case class Wstaw(n: Int)
case class Znajdź(n: Int)


class Węzeł extends Actor {

  def receive(wartość: Int): Receive = {
    case Wstaw(n: Int) => 
      context.become(liść(n))
    case _=>
      println(s"${self.path.name}: UNKNOWN MESSAGE")
  }

  def liść(wartość: Int): Receive = {
    case Wstaw(x) =>
      if(x > wartość){
        val prawe = context.system.actorOf(Props[Wezel]())
        prawe ! Wstaw(x)
        context.become(zPrawymPoddrzewem(prawe, wartość))
      }
      else if(x < wartość){
        val lewe = context.system.actorOf(Props[Wezel]())
        lewe ! Wstaw(x)
        context.become(zLewymPoddrzewem(lewe, wartość))
      }
      // wiadomo jak rowne, to nie wstawia, bo juz jest.
    case Znajdź(x) =>
      if(wartość == x) 
      {
        println(s"${self.path.name}: FOUND $n")
      }
      else 
      {
        println(s"${self.path.name}: NOT FOUND $n")
      }
    case _=>
      println(s"${self.path.name}: UNKNOWN MESSAGE")
  }

  def zLewymPoddrzewem(lewe: ActorRef, wartość: Int): Receive = {
    case Wstaw(x) =>
      if(x > wartość){
        val prawe = context.system.actorOf(Props[Wezel]())
        prawe ! Wstaw(x)
        context.become(zPoddrzewami(lewe, prawe, wartość))
      }
      else if(x < wartość){
        lewe ! Wstaw(x)
      }
    case Znajdź(x) =>
      if(n==wartość){
        println(s"${self.path.name}: FOUND $n")
      }
      else if(x < wartość){
        lewe ! Znajdź(x)
      }
      else{
        println(s"${self.path.name}: NOT FOUND $n")
      }
    case _=>    
      println(s"${self.path.name}: UNKNOWN MESSAGE")
  }

  def zPrawymPoddrzewem(wartość: Int, prawe: ActorRef): Receive = {
     case Wstaw(x) =>
      if(x > wartość){
        prawe ! Wstaw(x)
      }
      else if(x < wartość){
        val lewe = context.system.actorOf(Props[Węzeł]())
        lewe ! Wstaw(x)
        context.become(zPoddrzewami(lewe, prawe, wartość))
      }
    case Znajdź(x) =>
      if(n==wartość){
        println(s"${self.path.name}: FOUND $n")
      }
      else if(x > wartość){
        prawe ! Znajdź(x)
      }
      else{
        println(s"${self.path.name}: NOT FOUND $n")
      }
    case _=>
      println(s"${self.path.name}: UNKNOWN MESSAGE")
  }

  def zPoddrzewami(lewe: ActorRef, wartość: Int, prawe: ActorRef): Receive = {
    case Wstaw(x) =>
      if(x > wartość){
        prawe ! Wstaw(x)
      }
      if(x < wartość){
        lewe ! Wstaw(x)
      }
    case Znajdz(x) =>
      if(n==wartość){
        println(s"${self.path.name}: FOUND $n")
      }
      else if(x > wartość){
        prawe ! Znajdź(x)
      }
      else{
        lewe ! Znajdź(x)
      }
    case _=>
      println(s"${self.path.name}: UNKNOWN MESSAGE")
  }
  
}

object Zad1 extends App {
  val system = ActorSystem("system")
  val korzeń = system.actorOf(Props[Wezel](), "korzeń")

  korzeń ! Wstaw(12)
  korzeń ! Wstaw (23)
  korzeń ! Wstaw (24)
  korzeń ! Wstaw (10)

  korzeń ! Znajdź(2)
  korzeń ! Znajdź(24)
  korzeń ! Znajdź(10)

  println("**Naciśnij ENTER żeby zakończyć**")
  StdIn.readLine()
  system.terminate()

}
