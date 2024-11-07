

import Tip
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement
import java.util.ArrayList
import java.util.Objects
import kotlin.jvm.Throws

abstract class Specifikacija {

    abstract var tip : Tip


    abstract fun genR(izvestaj: Izvestaj, pathToFile: String)

    fun generateReport(podaci : List<List<Any>>, pathToFile: String){
        var izvestaj = Izvestaj(podaci)
        genR(izvestaj, pathToFile)
    }

    fun generateReport(podaci : List<List<Any>>, header : List<String>, pathToFile: String){
        var izvestaj = Izvestaj(podaci, null, header)
        genR(izvestaj, pathToFile)
    }

    fun generateReport(podaci : List<List<Any>>, title : String, rezime : Map<String, Int>, pathToFile: String){
        var izvestaj = Izvestaj(podaci, title)
        izvestaj.izracunajSummary(rezime)
        genR(izvestaj, pathToFile)
    }

    fun generateReport(podaci : List<List<Any>>, header : List<String>, title : String, rezime : Map<String, Any>, pathToFile: String){
        var izvestaj = Izvestaj(podaci, title, header)
        izvestaj.izracunajSummary(rezime)
        genR(izvestaj, pathToFile)
    }

    @Throws(SQLException::class)
    fun generateReport(conn : Connection, query : String, headerUse: Boolean, pathToFile: String){
        val statement : Statement = conn.createStatement()
        val rs : ResultSet = statement.executeQuery(query)
        generateReport(rs, headerUse, pathToFile)
    }

    fun generateReport(rs : ResultSet, headerUse : Boolean, pathToFile : String){
        val all : MutableList<List<String>> = ArrayList()
        val podaci = rs.metaData
        val numberOfColumns = podaci.columnCount
        while(rs.next()){
            val row : MutableList<String> = ArrayList()
            for(i in 1..numberOfColumns){
                row.add(rs.getString(i))
            }
            all.add(row)
        }
        if(!headerUse) generateReport(all, pathToFile)
        else{
            val header : MutableList<String> = ArrayList()
            for(i in 1..numberOfColumns) {
                header.add(podaci.getColumnLabel(i))
            }
            generateReport(all, header, pathToFile)
        }
    }
    fun generateReport(podaci : List<List<Any>>, headerUse: Boolean, pathToFile: String){
        if(!headerUse) generateReport(podaci, pathToFile)
        else{
            val novaLista : MutableList<List<Any>> = podaci.toMutableList()
            val header : MutableList<String> = ArrayList()
            for(i in 0..<podaci[0].size) {
                header.add(podaci[0][i].toString())
            }
            novaLista.removeAt(0)
            generateReport(podaci, header, pathToFile)
        }
    }

    fun generateReport(podaci : Map<String, List<Any>>,pathToFile: String){
        var header : MutableList<String> = ArrayList()
        var all : MutableList<List<Any>> = ArrayList()
        for ((key, value) in podaci) {
            header.add(key)
            all.add(value)
        }
        fun transpose(rows: List<List<Any>>): MutableList<List<Any>> {
            if (rows.isEmpty()) return mutableListOf()
            val numberOfColumns = rows[0].size
            return MutableList(numberOfColumns) { colIndex ->
                rows.map { it[colIndex] }
            }
        }//promena redova u kolone iz mape, da bi moglo da se prosledi kao lista u listi
        val transposed: MutableList<List<Any>> = transpose(all)

        generateReport(transposed, header, pathToFile)

    }

    fun generateReport(podaci : List<List<Any>>, headerUse: Boolean, title : String, rezime: Map<String, Int>, pathToFile: String){
        if(!headerUse) generateReport(podaci,title, rezime, pathToFile)
        else{
            val novaLista : MutableList<List<Any>> = podaci.toMutableList()
            val header : MutableList<String> = ArrayList()
            for(i in 0..<podaci[0].size) {
                header.add(podaci[0][i].toString())
            }
            novaLista.removeAt(0)
            generateReport(podaci, header, title, rezime, pathToFile)
        }
    }
    fun generateReport(podaci : Map<String, List<Any>>, title: String, rezime: Map<String, Any>, pathToFile: String){
        var header : MutableList<String> = ArrayList()
        var all : MutableList<List<Any>> = ArrayList()
        for ((key, value) in podaci) {
            header.add(key)
            all.add(value)
        }
        fun transpose(rows: List<List<Any>>): MutableList<List<Any>> {
            if (rows.isEmpty()) return mutableListOf()
            val numberOfColumns = rows[0].size
            return MutableList(numberOfColumns) { colIndex ->
                rows.map { it[colIndex] }
            }
        }//promena redova u kolone iz mape, da bi moglo da se prosledi kao lista u listi
        val transposed: MutableList<List<Any>> = transpose(all)

        generateReport(transposed, header, title, rezime, pathToFile)

    }









}