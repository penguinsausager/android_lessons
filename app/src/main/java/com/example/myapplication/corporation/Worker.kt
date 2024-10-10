package com.example.myapplication.corporation

abstract class Worker(
    open val id: Int,
    open val name: String,
    open val age: Int = 0,
    open val position: Position,
    open val salary: Int = 15000,

    ) {

    abstract fun copy(salary: Int = this.salary, age: Int = this.age): Worker

    abstract fun work()

    fun printInfo() {
        println(this)
    }


}