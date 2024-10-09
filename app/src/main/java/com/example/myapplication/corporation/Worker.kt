package com.example.myapplication.corporation

abstract class Worker(
    val id: Int,
    val name: String,
    val age: Int = 0,
    val position: Position,
    val salary: Int = 15000,

    ) {

    abstract fun copy(salary: Int = this.salary, age:Int = this.age): Worker

    abstract fun work()

    fun printInfo() {
        println(this)
    }

    override fun toString(): String {
        return "Id: $id Name: $name Age: $age Position: $position Salary: $salary"
    }
}