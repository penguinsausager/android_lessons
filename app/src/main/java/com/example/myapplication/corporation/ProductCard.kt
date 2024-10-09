package com.example.myapplication.corporation

abstract class ProductCard(
    val name: String,
    val brand: String,
    val price: Int,
    val productType: ProductType,
) {
    abstract fun printInfo()

    override fun toString(): String {
        return "Name: $name\nBrand: $brand\nPrice: $price\nProduct type: $productType\n"
    }
}