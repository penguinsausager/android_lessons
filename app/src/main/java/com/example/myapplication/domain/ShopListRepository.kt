package com.example.myapplication.domain

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem): ShopItem
    fun editShopItem(shopItem: ShopItem)
    fun getShopItem(shopItemId: Int):ShopItem
    fun getShopList(): List<ShopItem>
}