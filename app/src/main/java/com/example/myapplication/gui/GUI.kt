package com.example.myapplication.gui

fun main(){
    val rectangle = Rectangle(width = 10, height = 4)
    println(rectangle.area)

    rectangle.height = 10
    println(rectangle.area)
}