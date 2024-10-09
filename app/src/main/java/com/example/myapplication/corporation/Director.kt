package com.example.myapplication.corporation

class Director(
    id: Int,
    name: String,
    age: Int,
    salary: Int
) : Worker(
    id,
    name,
    age,
    Position.DIRECTOR,
    salary
), Supplier {

    override fun work() {
        println("I'm working now")
    }

    override fun copy(salary: Int, age: Int): Director {
        return Director(id, name, age, salary)
    }

    override fun buyThings() {
        println("My position is Director. I'm buying things...")
    }
}