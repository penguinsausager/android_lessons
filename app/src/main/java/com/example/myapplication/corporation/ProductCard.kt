package com.example.myapplication.corporation

abstract class ProductCard(
    open val name: String,
    open val brand: String,
    open val price: Int,
    open val productType: ProductType,
) {
    abstract fun printInfo()

    override fun toString(): String {
        return "Name: $name\nBrand: $brand\nPrice: $price\nProduct type: $productType\n"
    }
}