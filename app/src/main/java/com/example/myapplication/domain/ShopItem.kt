package com.example.myapplication.domain
// SOLID - S - Класс должен отвечать только за что-то одно
//S - single responsibility принцип единой отвественности

data class ShopItem(
    val name: String,
    val count: Int,
    val enabled: Boolean,
    var id: Int = UNDEFINED_ID,
    ) {
    companion object {
        const val UNDEFINED_ID = -1
    }
}
