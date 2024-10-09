package com.example.myapplication.corporation

abstract class Worker(
    val id: Int,
    val name: String,
    val age: Int = 0,
    val position: Position,
    private var salary: Int = 15000,

    ) {

    fun setSalary(salary: Int) {
        if (salary < this.salary) {
            println("The new salary is too small...")
        } else this.salary = salary
    }

    fun getSalary() = this.salary


    abstract fun work()

    fun printInfo() {
        println(this)
    }

    override fun toString(): String {
        return "Id: $id Name: $name Age: $age Position: $position Salary: $salary"
    }
}