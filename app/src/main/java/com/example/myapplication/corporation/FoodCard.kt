package com.example.myapplication.corporation

class FoodCard(
    name: String,
    brand: String,
    price: Int,
    val cal: Int,
): ProductCard(
    name = name,
    brand = brand,
    price = price,
    ProductType.FOOD
) {
    override fun printInfo() {
        print(this)
        println("Cal: $cal")
    }
}