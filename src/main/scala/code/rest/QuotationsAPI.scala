package code.rest

import net.liftweb.http.rest.RestHelper
import net.liftweb.http.LiftRules
import net.liftweb.json.JsonAST._
import net.liftweb.json.JsonDSL._

object QuotationsAPI extends RestHelper {
	def init(): Unit = {
		LiftRules.statelessDispatch.append(QuotationsAPI)
	}
	
	serve {
		case "quotation" :: Nil JsonGet req => 
			("text" -> "a beach house is not just real estate. It's a state of mind") ~ 
			("by" -> "Douglas Adam"): JValue
	}
}