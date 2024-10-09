package com.example.myapplication.corporation

class Consultant(
    id: Int,
    name: String,
    age: Int,
    salary: Int,
) : Worker(
    id,
    name,
    age,
    Position.CONSULTANT,
    salary,
), Cleaner {
    override fun work() {
        println("Consultation")
    }

    override fun copy(salary: Int, age: Int): Consultant {
        return Consultant(id, name, age, salary)
    }

    override fun clean() {
        println("My position is Consultant. I'm cleaning workplace...")
    }
}