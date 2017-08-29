package example

import org.jsoup.Jsoup
import scala.collection.JavaConverters._
import scala.collection.JavaConversions._

object WebCrawler extends App {

  val HOMEPAGE = "http://www.ikea.com"

  //val doc = Jsoup.connect("http://en.wikipedia.org/").get
  val doc = Jsoup.connect(s"$HOMEPAGE/es/es/").get
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
  enlaces.foreach(e => println(e.select("a").first().attr("href")))
  val firstLink = enlaces.first().select("a").first().attr("href")
  val camasDoc = Jsoup.connect(s"$HOMEPAGE$firstLink").get()
  println(s"NEW PAGE ${"-"*25}")
  println(camasDoc.body().html())
  println(s"gridRow ${"-"*25}")
  val gridRow = camasDoc.body().getElementsByClass("gridRow")
  println(gridRow.html())
  println(s"categoryContainer ${"-"*25}")
  val categoryContainers = gridRow.map(_.getElementsByClass("categoryContainer")).filter(_.nonEmpty).flatten
  categoryContainers.foreach(println)
  println(s"Links ${"-"*25}")
  val divs = categoryContainers.map(_.select("a")).filter(_.hasClass("categoryNumber"))
  val camasLinks = divs.map(_.attr("href"))
  camasLinks.foreach(println)
}

