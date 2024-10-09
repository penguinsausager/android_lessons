package com.example.myapplication.profile

class Person
    (
    private val name: String,
    private var surname: String,
    private val height: Int,
    private val weight: Int,
) {
    private val fullName: String
        get() = "$name $surname"

    var age: Int = 0
        set(value: Int){
            if (value > field){
                field = value
            }else println("The new age must be bigger than the old one")
        }
        get(){
            println("Спрашивать о возрасте неприлично!")
            return field
        }

    fun sayHello() {
        println("Hello! My name is $name")
    }

    fun printInfo(){
        println("$name, $age, $height, $weight")
    }

}