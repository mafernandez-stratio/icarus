package example

import org.jsoup.Jsoup
import scala.collection.JavaConverters._
import scala.collection.JavaConversions._

object WebCrawler extends App {

  //val doc = Jsoup.connect("http://en.wikipedia.org/").get
  val doc = Jsoup.connect("http://www.ikea.com/es/es/").get
  println(s"outerHtml ${"-"*25}")
  //println(doc.outerHtml())
  val mainMenu = doc.getElementsByClass("row-desktop main-ikea-nav")
  println(s"row-desktop main-ikea-nav ${"-"*25}")
  println(mainMenu.html())
  println(s"desplegable-content productos ${"-"*25}")
  val products = mainMenu.first().children().first().getElementsByClass("desplegable-content productos")
  println(s"caja-enlace ${"-"*25}")
  val enlaces = products.first().getElementsByClass("caja-enlace")
  println(enlaces.html())
  println(s"first ${"-"*25}")
  println(enlaces.first().html())
  println(s"Camas ${"-"*25}")
  println(enlaces.first().select("a").first().attr("href"))
  //val newsHeadlines = doc.select("#mp-itn b a")
  //newsHeadlines.eachText().foreach(e => println(s"Element: $e"))
}

