package com.example.myapplication.corporation

abstract class Worker(
    val id: Int,
    val name: String,
    val age: Int = 0,
    val position: Position,
    val salary: Int = 15000,

    ) {

    abstract fun copy(salary: Int = this.salary, age: Int = this.age): Worker

    override fun equals(other: Any?): Boolean {
        if (other !is Worker) return false
        return id == other.id &&
                name == other.name &&
                age == other.age &&
                position == other.position &&
                salary == other.salary

    }

    abstract fun work()

    fun printInfo() {
        println(this)
    }

    override fun toString(): String {
        return "Id: $id Name: $name Age: $age Position: $position Salary: $salary"
    }
}