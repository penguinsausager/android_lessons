package com.example.myapplication.files

import java.io.File

fun main() {
    val file = File("test2.txt")

    val types = OperationType.entries

    while (true) {
        println("Ведите код операции: ")
        for((index, code) in types.withIndex()){
            println("$index - ${code.title}")
        }
        val operationIndex = readln().toInt()
        val operationCode = types[operationIndex]

        when (operationCode) {
            OperationType.BREAK_OPERATION -> break
            OperationType.NEW_ELEMENT -> {
                println("Введите новый элемент ")
                val item = readln()
                if(item == "0") {
                    break
                }
                file.appendText(item)
            }
            OperationType.SHOW_ALL_ITEMS -> println(file.readText())
        }
    }
}