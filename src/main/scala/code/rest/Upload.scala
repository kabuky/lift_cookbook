package code.rest

import net.liftweb.http.rest.RestHelper
import net.liftweb.http.LiftRules

object Upload extends RestHelper {
	def init(): Unit = {
		LiftRules.statelessDispatch.append(Upload)
	}
	
	serve {
		case "upload" :: Nil Post req =>
			for {
				bodyBytes <- req.body
			} yield <info>Received {bodyBytes.length} bytes</info>
		case "uploadtest" :: Nil XmlGet _ => <p>None open</p>
	}
}