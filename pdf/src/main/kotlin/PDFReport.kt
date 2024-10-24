package pdf

import Specifikacija
import Tip
import org.xhtmlrenderer.pdf.ITextRenderer
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStreamWriter
import java.nio.file.Paths


class PDFReport: Specifikacija() {
    override var tip= Tip.PDF

    override fun generateReport(podaci: List<List<Any>>, pathToFile: String) {

        val stringBuilder = StringBuilder()
        stringBuilder.append("<html><body><table border='1'>\n") // Start the table
        for (row in podaci) {
            stringBuilder.append("  <tr>\n") // Start a new row
            for (cell in row) {
                stringBuilder.append("    <td>$cell</td>\n") // Add cell data
            }
            stringBuilder.append("  </tr>\n") // End the row
        }
        stringBuilder.append("</table></body></html>") // End the table
        val html = stringBuilder.toString()
        try {
            val outputStream = FileOutputStream(pathToFile)
            val renderer = ITextRenderer()


            renderer.setDocumentFromString(html)
            renderer.layout()


            renderer.createPDF(outputStream)


            outputStream.close()
        }catch (e: java.lang.Exception) {
            e.printStackTrace()
        }


    }

    override fun generateReport(podaci: List<List<Any>>, header: List<String>, pathToFile: String) {
        val stringBuilder = StringBuilder()
        stringBuilder.append("<html><body><table border='1'>\n")
        stringBuilder.append("  <tr>\n")
        for (h in header) {

            stringBuilder.append("    <th>$h</th>\n")

        }
        stringBuilder.append("  </tr>\n")
        for (row in podaci) {
            stringBuilder.append("  <tr>\n")
            for (cell in row) {
                stringBuilder.append("    <td>$cell</td>\n")
            }
            stringBuilder.append("  </tr>\n")
        }
        stringBuilder.append("</table></body></html>")
        val html = stringBuilder.toString()
        try {
            val outputStream = FileOutputStream(pathToFile)
            val renderer = ITextRenderer()


            renderer.setDocumentFromString(html)
            renderer.layout()


            renderer.createPDF(outputStream)


            outputStream.close()
        }catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    override fun generateReport(podaci: List<List<Any>>, title: String, rezime: Map<String, Int>, pathToFile: String) {
        val stringBuilder = StringBuilder()
        stringBuilder.append("<html><body><h1>$title</h1><table border='1'>\n") // Start the table

        for (row in podaci) {
            stringBuilder.append("  <tr>\n")
            for (cell in row) {
                stringBuilder.append("    <td>$cell</td>\n")
            }
            stringBuilder.append("  </tr>\n")
        }
        stringBuilder.append("</table>\n")
        stringBuilder.append("<h2>Rezime</h2>\n")
       stringBuilder.append("<table>\n")
        rezime.forEach { (key, value) ->
            stringBuilder.append("  <tr>\n")
            stringBuilder.append("    <td>$key</td>\n")
            stringBuilder.append("    <td> : </td>\n")
            stringBuilder.append("    <td>$value</td>\n")
            stringBuilder.append("  </tr>\n")
        }
        stringBuilder.append("</table>\n")

        stringBuilder.append("</body></html>")
        val html = stringBuilder.toString()
        try {
            val outputStream = FileOutputStream(pathToFile)
            val renderer = ITextRenderer()


            renderer.setDocumentFromString(html)
            renderer.layout()


            renderer.createPDF(outputStream)


            outputStream.close()
        }catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    override fun generateReport(podaci: List<List<Any>>, header: List<String>, title: String, rezime: Map<String, Int>, pathToFile: String) {
        val stringBuilder = StringBuilder()
        stringBuilder.append("<html><body><h1>$title</h1><table border='1'>\n") // Start the table
        stringBuilder.append("  <tr>\n")
        for (h in header) {

            stringBuilder.append("    <th>$h</th>\n")

        }
        stringBuilder.append("  </tr>\n")
        for (row in podaci) {
            stringBuilder.append("  <tr>\n")
            for (cell in row) {
                stringBuilder.append("    <td>$cell</td>\n")
            }
            stringBuilder.append("  </tr>\n")
        }
        stringBuilder.append("</table>\n")
        stringBuilder.append("<h2>Rezime</h2>\n")
        stringBuilder.append("<table>\n")
        rezime.forEach { (key, value) ->
            stringBuilder.append("  <tr>\n")
            stringBuilder.append("    <td>$key</td>\n")
            stringBuilder.append("    <td> : </td>\n")
            stringBuilder.append("    <td>$value</td>\n")
            stringBuilder.append("  </tr>\n")
        }
        stringBuilder.append("</table>\n")

        stringBuilder.append("</body></html>")
        val html = stringBuilder.toString()
        try {
            val outputStream = FileOutputStream(pathToFile)
            val renderer = ITextRenderer()


            renderer.setDocumentFromString(html)
            renderer.layout()


            renderer.createPDF(outputStream)


            outputStream.close()
        }catch (e: Exception) {
            e.printStackTrace()
        }

    }

}