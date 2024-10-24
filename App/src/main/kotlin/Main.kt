package org.example

import Specifikacija
import Tip
import java.util.ServiceLoader


fun main() {
    val serviceLoader = ServiceLoader.load(Specifikacija::class.java)

    val exportedServices = mutableMapOf<Tip, Specifikacija>()
    serviceLoader.forEach {
            service -> exportedServices.put(service.tip,service)
    }
    println(exportedServices.keys)
//    exportedServices.get(Tip.EXCEL)!!.generateReport(listOf(
//        listOf("ivana", 24, "kalu"),
//        listOf("miljana", 24, "kalu"),
//        listOf("tamara",25,"vrac")
//    ),"sacuvaj.xlsx")
//     exportedServices.get(Tip.CSV)!!.generateReport(listOf(
//        listOf("ivana", 24, "kalu"),
//        listOf(),
//        listOf("tamara",25,"vracaaaaaa")
//     ),"sacuvajsd.csv")
//    exportedServices.get(Tip.EXCEL)!!.generateReport(listOf(
//        listOf("ivana", 24, "kalu"),
//        listOf("miljana", 24, "kalu"),
//        listOf("tamara",25,"vrac")
//    ), listOf("ime","god","opstina"),"sacuvajDrugi.xlsx")
    exportedServices.get(Tip.EXCEL)!!.generateReport(listOf(
        listOf("ivana", 24, "kalu"),
        listOf("miljana", 24, "kalu"),
        listOf("tamara",25,"vrac")
    ), listOf("ime","god","opstina"),"Naslov Tabele", mutableMapOf("suma" to 35),"pdf3.xlsx")

//
//    exportedServices.get(Tip.CSV)!!.generateReport(listOf(
//        listOf("ime","god","opstina"),
//        listOf("ivana", 24, "kalu"),
//        listOf("miljana", 24, "kalu"),
//        listOf("tamara",25,"vrac"),
//
//        ),"sacuvajTreci.txt")
//    exportedServices.get(Tip.CSV)!!.generateReport(mutableMapOf(
//        "prvi" to listOf(1, 2, 3),
//        "drugi" to listOf(),
//        "treci" to listOf(7, 8, 9)
//    ),"sacuvajCetvr.txt")
//      table = generateTable(list<list<Any>>)
// table.addColumn(kalkulacija, 3, 4, 6
//    exportedServices.get(Tip.PDF)!!.generateReport(listOf(
//        listOf("ime","god","opstina"),
//        listOf("ivana", 24, "kalu"),
//        listOf("miljana", 24, "kalu"),
//        listOf("tamara",25,"vracaaaaaaaar"),
//
//        ),"pdf1.pdf")
//    exportedServices.get(Tip.PLAIN_TEXT)!!.generateReport(listOf(
//        listOf("ivana", 24, "kalu"),
//        listOf("miljana", 24, "kalu"),
//        listOf("tamara",25,"vrac")
//    ), listOf("ime","god","opstina"),"pdf2.txt")

//    exportedServices.get(Tip.EXCEL)!!.generateReport(listOf(
//        listOf("ivana", 24, "kalu"),
//        listOf("miljana", 24, "kalu"),
//        listOf("tamara",25,"vrac")
//    ),"Naslov Tabele", mutableMapOf("suma" to 35),"pdf3.xlsx")
//
//    exportedServices.get(Tip.PDF)!!.generateReport(mutableMapOf(
//        "prvi" to listOf(1, 2, 3),
//        "drugi" to listOf(4, 5, 6),
//        "treci" to listOf(7, 8, 9)
//    ),"pdf4.pdf")
//
//    exportedServices.get(Tip.PDF)!!.generateReport(listOf(
//        listOf("ime","god","opstina"),
//        listOf("ivana", 24, "kalu"),
//        listOf("miljana", 24, "kalu"),
//        listOf("tamara",25,"vracaaaaaaaar"),
//
//        ),true,"pdf5.pdf")
//
//
//    exportedServices.get(Tip.PDF)!!.generateReport(listOf(
//        listOf("ime","god","opstina"),
//        listOf("ivana", 24, "kalu"),
//        listOf("miljana", 24, "kalu"),
//        listOf("tamara",25,"vracaaaaaaaar"),
//
//        ),"pdf6.pdf")
}