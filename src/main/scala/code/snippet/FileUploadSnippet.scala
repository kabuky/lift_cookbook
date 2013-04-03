package code
package snippet

import net.liftweb.util.Helpers._
import net.liftweb.http.SHtml._
import net.liftweb.http.FileParamHolder
import net.liftweb.common.{Loggable, Full, Empty, Box}

class FileUploadSnippet extends Loggable {
	def render = {
		var upload: Box[FileParamHolder] = Empty
		
		def processForm() = upload match {
			case Full(FileParamHolder(_, mimeType, fileName, file)) =>
				logger.info("%s of type %s is %d bytes long" format (fileName, mimeType, file.length))
			
			case _ => logger.info("No File?")
		}
		
		"#file" #> fileUpload(f => upload = Full(f)) & 
			"type=submit" #> onSubmitUnit(processForm)
	}
}