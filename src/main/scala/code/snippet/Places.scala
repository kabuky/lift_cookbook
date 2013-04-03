package code
package snippet

import code.model._
import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import code.lib._
import Helpers._

class Places {
	val uk = Country.find("uk") openOr {
		val info = Map(
			"Brighton" -> 134924,
			"Birmingham" -> 452874,
			"Liverpool" -> 821045
		)
		
		Country.createRecord.id("uk").population(info).save
	}
	
	def facts = "#facts" #> (
		for { (name, pop) <- uk.population.is } yield
			".name *" #> name & ".pop *" #> pop
	)
}