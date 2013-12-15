package org.shuhaiber

import org.apache.commons.io.FileUtils
import java.io.File
import org.apache.commons.io.filefilter.TrueFileFilter
import scala.collection.JavaConverters._

object FileSearcher {
	def grep(filePath: String, pattern: String, action: (File, String) => Unit) = {
		val filesHere = FileUtils.iterateFiles(new File(filePath), TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE).asScala	

		def scalaFiles =
			for {
				file <- filesHere
				if file.getName.endsWith(".scala")
			} yield file

		def getLines = (file: File) => scala.io.Source.fromFile(file).getLines()

		for {
			file <- scalaFiles
			line <- getLines(file)
			trimmed = line.trim
			if trimmed.matches(pattern)
		} action(file, trimmed)
	}
}