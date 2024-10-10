package com.example.myapplication.corporation

data class Consultant(
    override val id: Int,
    override val name: String,
    override val age: Int,
    override val salary: Int,
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