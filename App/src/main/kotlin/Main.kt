package org.example

import java.util.ServiceLoader

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val serviceProvider = ServiceLoader.load(Specifikacija::class.java)
}