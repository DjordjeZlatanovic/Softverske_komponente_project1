package pt
import Specifikacija
import Tip
import jdk.internal.org.jline.utils.AttributedStringBuilder.append
import java.io.File
import java.io.IOException

class PlainText() : Specifikacija(){
    override var tip = Tip.PLAIN_TEXT



    override fun generateReport(podaci: List<List<Any>>, pathToFile: String) {
        val maxDuzina = MutableList(podaci[0].size) { 0 }
        val stringList: List<List<String>> = podaci.map { row ->
            row.map { cell ->
                cell.toString()
            }
        }
        var count : Int = 0
        for (col in 0 until maxDuzina.size) {
            for (row in stringList) {
                if (col < row.size && row[col].length > maxDuzina[col]) {
                    maxDuzina[col] = row[col].length
                }
            }
        }
        val result = buildString {
            for (row in stringList) {
                for (col in 0 until maxDuzina.size) {
                        if (row[col].length < maxDuzina[col]) {
                            append(row[col])
                            append(" ".repeat(maxDuzina[col] - row[col].length))
                        } else {
                            append(row[col])
                        }
                    append("\t\t")
                }
                append("\n")
            }
        }
        try{
            File(pathToFile).writeText(result)
        }catch (e : IOException){
            println("Greska")
        }

    }

    override fun generateReport(podaci: List<List<Any>>, header: List<String>, pathToFile: String) {
        val maxDuzina = MutableList(podaci[0].size) { 0 }
        var count : Int = 0
        for (col in header) {
            if(col.length > maxDuzina[count])
                maxDuzina[count] = col.length
            count++
        }
        val stringList: List<List<String>> = podaci.map { row ->
            row.map { cell ->
                cell.toString()
            }
        }

        for (col in 0 until maxDuzina.size) {
            for (row in stringList) {
                if (col < row.size && row[col].length > maxDuzina[col]) {
                    maxDuzina[col] = row[col].length
                }
            }
        }
        count = 0
        val result = buildString {
            for(col in header){
                if(col.length < maxDuzina[count]){
                    append(col)
                    append(" ".repeat(maxDuzina[count] - col.length))
                }
                else{
                    append(col)
                }
                count++
                append("\t\t")
            }
            append("\n")
            count = 0
            for(col in header){
                if(col.length < maxDuzina[count]){
                    append("-".repeat(maxDuzina[count]))
                }
                else{
                    append("-".repeat(col.length))
                }
                count++
                append("\t\t")
            }
            append("\n")
            for (row in stringList) {
                for (col in 0 until maxDuzina.size) {
                    if (row[col].length < maxDuzina[col]) {
                        append(row[col])
                        append(" ".repeat(maxDuzina[col] - row[col].length))
                    } else {
                        append(row[col])
                    }
                    append("\t\t")
                }
                append("\n")
            }
        }
        try{
            File(pathToFile).writeText(result)
        }catch (e : IOException){
            println("Greska")
        }
    }

    override fun generateReport(podaci: List<List<Any>>, title: String, rezime: Map<String, Int>, pathToFile: String) {
        val maxDuzina = MutableList(podaci[0].size) { 0 }
        val stringList: List<List<String>> = podaci.map { row ->
            row.map { cell ->
                cell.toString()
            }
        }
        var count : Int = 0
        for (col in 0 until maxDuzina.size) {
            for (row in stringList) {
                if (col < row.size && row[col].length > maxDuzina[col]) {
                    maxDuzina[col] = row[col].length
                }
            }
        }
        val result = buildString {
            append(title)
            append("\n")
            for (row in stringList) {
                for (col in 0 until maxDuzina.size) {
                    if (row[col].length < maxDuzina[col]) {
                        append(row[col])
                        append(" ".repeat(maxDuzina[col] - row[col].length))
                    } else {
                        append(row[col])
                    }
                    append("\t\t")
                }
                append("\n")
            }
            for((key,value) in rezime){
                append(key, "\t",value)
                append("\n")
            }
        }
        try{
            File(pathToFile).writeText(result)
        }catch (e : IOException){
            println("Greska")
        }
    }

    override fun generateReport(podaci: List<List<Any>>,header: List<String>,title: String,rezime: Map<String, Int>,pathToFile: String) {
        TODO("Not yet implemented")
    }

}