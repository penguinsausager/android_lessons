package com.example.myapplication.corporation

class ApplianceCard(
    name: String,
    brand: String,
    price: Int,
    val wattage: Int,
): ProductCard(
    name = name,
    brand = brand,
    price = price,
    ProductType.APPLIANCE,
) {
    override fun printInfo() {
        print(this)
        println("Cal: $wattage")
    }
}