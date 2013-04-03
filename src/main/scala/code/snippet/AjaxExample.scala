package code
package snippet

import net.liftweb.util.Helpers._
import net.liftweb.util.PassThru
import net.liftweb.http.SHtml
import net.liftweb.http.js._
import JsCmds._

import scala.xml.Text

class AjaxExample {
	var inputVal = "default"
	
	def process(): JsCmd = {
		println("receive: " + inputVal)
		SetHtml("result", Text(inputVal))
	}
	
	def render() = {
		"name=info" #> (
			SHtml.text(inputVal, inputVal = _) ++
			SHtml.hidden(process)
		)
	}
}

class Likes {
	var likeTurtles = false;
	
	def disabler = 
		if (math.random > 0.5d) "* [disabled]" #> "disabled"
		else PassThru
	
	def conditionallyDisabledCheckbox = "*" #> disabler(SHtml.checkbox(likeTurtles, likeTurtles = _))
	
	def checkbox = "*" #> SHtml.checkbox(likeTurtles, likeTurtles = _)
}

class MySnippet {
	def multi = {
		case class Item(id: String, name: String)
		val inventory = Item("a", "Coffee") :: Item("b", "Milk") :: Item("c", "Sugar") :: Nil
		
		val options: List[(String, String)] = inventory.map(i => (i.id -> i.name))
		
		val default = inventory.head.id :: Nil
		
		"#opts *" #> SHtml.multiSelect(options, default, xs => println("Selected: " + xs))
	}
}