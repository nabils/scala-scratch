package org.shuhaiber

import java.io.File
import org.joda.time.DateTime

object Main extends App {
	val dateTime = new DateTime
	val in3Months = dateTime.plusMonths(3)

	FileSearcher.grep(
		filePath = "/Users/nabilshuhaiber/Desktop/Dev", 
		pattern = ".*Main.*", 
		action = (file: File, line: String) => println(file.getAbsolutePath + ": " + line))
}