package com.example.myapplication.corporation

data class Assistant(
    override val id: Int,
    override val name: String,
    override val age: Int,
    override val salary: Int,
) : Worker(
    id,
    name,
    age,
    Position.ASSISTANT,
    salary = salary
), Cleaner, Supplier {

    override fun copy(salary: Int, age: Int): Assistant {
        return Assistant(id, name, age, salary)
    }

    override fun work() {
        println("Bring coffee")
    }

    fun bringCoffee(){
        println("Bringing coffee")
    }

    override fun clean() {
        println("My position is Assistant. I'm cleaning workplace...")
    }

    override fun buyThings() {
        println("My position is Assistant. I'm buying things...")
    }

}