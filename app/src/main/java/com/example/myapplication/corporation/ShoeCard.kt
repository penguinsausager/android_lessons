package com.example.myapplication.corporation

data class ShoeCard(
    override val name: String,
    override val brand: String,
    override val price: Int,
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