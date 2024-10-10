package com.example.myapplication.corporation

data class Director(
    override val id: Int,
    override val name: String,
    override val age: Int,
    override val salary: Int
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

    fun takeCoffee(assistant: Assistant) {
        val drinkName: String = assistant.bringCoffee().toString()
    }

    override fun buyThings() {
        println("My position is Director. I'm buying things...")
    }
}