package com.example.myapplication.corporation

class FoodCard(
    override val name: String,
    override val brand: String,
    override val price: Int,
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