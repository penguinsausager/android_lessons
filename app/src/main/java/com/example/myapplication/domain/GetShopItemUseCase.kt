package com.example.myapplication.domain

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopItemUseCase(shopItemId: Int): ShopItem{
        return shopListRepository.getShopItem(shopItemId)
    }
}