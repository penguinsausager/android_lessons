package com.example.myapplication.domain

class DeleteShopItemUseCase (private val shopListRepository: ShopListRepository) {
    fun deleteShopItem(shopItem: ShopItem) {
        shopListRepository.deleteShopItem(shopItem)
    }
}