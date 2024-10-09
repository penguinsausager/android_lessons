package com.example.myapplication.corporation

class Assistant(
    id: Int,
    name: String,
    age: Int,
    salary: Int,
) : Worker(
    id,
    name,
    age,
    Position.ASSISTANT,
    salary = salary
), Cleaner, Supplier {
    override fun work() {
        println("Bring coffee")
    }

    override fun clean() {
        println("My position is Assistant. I'm cleaning workplace...")
    }

    override fun buyThings() {
        println("My position is Assistant. I'm buying things...")
    }
}