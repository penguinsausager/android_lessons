package com.example.myapplication.domain
// SOLID - S - Класс должен отвечать только за что-то одно
//S - single responsibility принцип единой отвественности

class ShopItem(
    val id: Int,
    val name: String,
    val count: Int,
    val enabled: Boolean
)
