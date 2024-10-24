package csv

import Specifikacija
import Tip
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVPrinter


import java.io.File
import java.io.FileWriter

class CSVReport() : Specifikacija() {
    override var tip = Tip.CSV

    override fun generateReport(podaci: List<List<Any>>, pathToFile: String) {

        //println("ne moze")
        val velicina = podaci[0]
        for(i in 0..<podaci[0].size) {
            if(podaci[i].size!=podaci[i+1].size) {
                println("${podaci[i].size},${podaci[i+1].size}")
                throw IllegalArgumentException("Pogresan broj kolona i redova")
            }
        }

        try {
            val writer = FileWriter(File(pathToFile))
            val csvPrinter = CSVPrinter(writer, CSVFormat.DEFAULT)
            for (row in podaci) {
                csvPrinter.printRecord(row)
            }
            writer.close()
            csvPrinter.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun generateReport(podaci: List<List<Any>>, header: List<String>, pathToFile: String) {
        try {
            val writer = FileWriter(File(pathToFile))
            val csvPrinter = CSVPrinter(writer, CSVFormat.DEFAULT)
            csvPrinter.printRecord(header)
            for (row in podaci) {
                csvPrinter.printRecord(row)
            }
            writer.close()
            csvPrinter.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun generateReport(podaci: List<List<Any>>, title: String, rezime: Map<String, Int>, pathToFile: String) {
        throw IllegalArgumentException("CSV cannot have title and summary")
    }

    override fun generateReport(podaci: List<List<Any>>,header: List<String>,title: String,rezime: Map<String, Int>,pathToFile: String) {
        throw IllegalArgumentException("CSV cannot have title and summary")
    }
}