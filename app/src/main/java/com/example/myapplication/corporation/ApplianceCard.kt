package com.example.myapplication.corporation

class ApplianceCard(
    override val name: String,
    override val brand: String,
    override val price: Int,
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