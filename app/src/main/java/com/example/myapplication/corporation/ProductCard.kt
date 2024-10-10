package com.example.myapplication.corporation

abstract class ProductCard(
    open val name: String,
    open val brand: String,
    open val price: Int,
    val productType: ProductType,
) {
    open fun printInfo(){
        println(this)
    }

}