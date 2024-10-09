package com.example.myapplication.cats

class Cat(val name: String): CatsFamily() {

    fun playWithMouse(){
        println("I'm playing with mouse")
    }

    override fun eat() {
        println("I'm eating")
    }
}