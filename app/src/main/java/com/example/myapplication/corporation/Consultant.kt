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

    override fun clean() {
        println("My position is Consultant. I'm cleaning workplace...")
    }
}