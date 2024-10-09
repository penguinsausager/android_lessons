package com.example.myapplication.corporation

class ShoeCard(
    name: String,
    brand: String,
    price: Int,
    val size: Int,
): ProductCard(
    name = name,
    brand = brand,
    price = price,
    ProductType.SHOE
) {
    override fun printInfo() {
        print(this)
        println(" Size: $size")

    }
}