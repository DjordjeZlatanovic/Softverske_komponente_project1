package excel

import Specifikacija
import Tip
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.FileOutputStream

class EXCELReport:Specifikacija() {
    override var tip = Tip.EXCEL

    override fun generateReport(podaci: List<List<Any>>, pathToFile: String) {
        val workBook = XSSFWorkbook()

        val sheet = workBook.createSheet("Izvestaj")

        for((rowIndex, row) in podaci.withIndex()){
            val excelRow = sheet.createRow(rowIndex)
            for((colIndex, cellValue) in row.withIndex()){
                val cell = excelRow.createCell(colIndex)
                cell.setCellValue("$cellValue")
            }
        }
        FileOutputStream(pathToFile).use{ outputStream ->
            workBook.write(outputStream)
        }
        workBook.close()

    }

    override fun generateReport(podaci: List<List<Any>>, header: List<String>, pathToFile: String) {
        val workBook = XSSFWorkbook()

        val sheet = workBook.createSheet("Izvestaj")

        val headerRow = sheet.createRow(0)
        for ((colIndex, cellValue) in header.withIndex()) {
            val cell = headerRow.createCell(colIndex)
            cell.setCellValue(cellValue)
        }
        for((rowIndex, row) in podaci.withIndex()){
            val excelRow = sheet.createRow(rowIndex + 1)
            for((colIndex, cellValue) in row.withIndex()){
                val cell = excelRow.createCell(colIndex)
                cell.setCellValue("$cellValue")
            }
        }
        FileOutputStream(pathToFile).use{ outputStream ->
            workBook.write(outputStream)
        }
        workBook.close()
    }

    override fun generateReport(podaci: List<List<Any>>, title: String, rezime: Map<String, Int>, pathToFile: String) {
        val workBook = XSSFWorkbook()

        val sheet = workBook.createSheet("Izvestaj")

        val headerRow = sheet.createRow(0)
        val headerCell = headerRow.createCell(0)
        headerCell.setCellValue("$title")
        for((rowIndex, row) in podaci.withIndex()){
            val excelRow = sheet.createRow(rowIndex + 1)
            for((colIndex, cellValue) in row.withIndex()){
                val cell = excelRow.createCell(colIndex)
                cell.setCellValue("$cellValue")
            }
        }
        val lastRowNum = sheet.lastRowNum

        val summaryRow = sheet.createRow(lastRowNum + 1)
        var summaryCellIndex = 0

        for (key in rezime.keys) {
            summaryRow.createCell(summaryCellIndex++).setCellValue("$key")
        }

        val dataRow = sheet.createRow(lastRowNum + 2)
        var dataCellIndex = 0
        for (value in rezime.values) {
            dataRow.createCell(dataCellIndex++).setCellValue(value.toDouble()) // Set each value
        }

        FileOutputStream(pathToFile).use{ outputStream ->
            workBook.write(outputStream)
        }
        workBook.close()
    }

    override fun generateReport(podaci: List<List<Any>>, header: List<String>, title: String, rezime: Map<String, Int>, pathToFile: String) {
        val workBook = XSSFWorkbook()

        val sheet = workBook.createSheet("Izvestaj")

        val titleRow = sheet.createRow(0)
        val titleCell = titleRow.createCell(0)
        titleCell.setCellValue("$title")

        val headerRow = sheet.createRow(1)
        for ((colIndex, cellValue) in header.withIndex()) {
            val cell = headerRow.createCell(colIndex)
            cell.setCellValue(cellValue)
        }
        for((rowIndex, row) in podaci.withIndex()){
            val excelRow = sheet.createRow(rowIndex + 2)
            for((colIndex, cellValue) in row.withIndex()){
                val cell = excelRow.createCell(colIndex)
                cell.setCellValue("$cellValue")
            }
        }
        val lastRowNum = sheet.lastRowNum

        val summaryRow = sheet.createRow(lastRowNum + 1)
        var summaryCellIndex = 0

        for (key in rezime.keys) {
            summaryRow.createCell(summaryCellIndex++).setCellValue("$key")
        }

        val dataRow = sheet.createRow(lastRowNum + 2)
        var dataCellIndex = 0
        for (value in rezime.values) {
            dataRow.createCell(dataCellIndex++).setCellValue(value.toDouble()) // Set each value
        }

        FileOutputStream(pathToFile).use{ outputStream ->
            workBook.write(outputStream)
        }
        workBook.close()
    }
}
