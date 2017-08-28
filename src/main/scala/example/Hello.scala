package example

import org.jsoup.Jsoup
import scala.collection.JavaConverters._
import scala.collection.JavaConversions._

object Hello extends App {

  //val doc = Jsoup.connect("http://en.wikipedia.org/").get
  val doc = Jsoup.connect("http://www.ikea.com/es/es/").get
  println(doc.outerHtml())
  println("-"*22)
  println(doc.body().firstElementSibling().html())
  //val newsHeadlines = doc.select("#mp-itn b a")
  //newsHeadlines.eachText().foreach(e => println(s"Element: $e"))
}

