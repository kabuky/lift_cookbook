package code.rest

import net.liftweb.http.rest.RestHelper
import net.liftweb.http.LiftRules
import xml.Text

object Reunite extends RestHelper {
	private def reunite(name: String, suffix: String) = 
		if (suffix.isEmpty) name else name + "." + suffix
		
	serve {
		case "download" :: file :: Nil Get req => 
			Text("You requested " + reunite(file, req.path.suffix))
	}
	
	def init(): Unit = {
		LiftRules.statelessDispatch.append(Reunite)
	}
}