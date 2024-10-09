package com.example.myapplication.files

import java.io.File

fun main(){
    val file = File("test.txt")
    file.appendText("Hello")
}