package com.example.myapplication.corporation

import java.io.File

object ProductCardsRepository {

    private val fileProductCarts = File("product_cards.txt")
    private val _productCards = loadAllCards()
    val productCards
        get() = _productCards.toList()

    fun removeProductCard(name: String) {
        for (card in _productCards) {
            if (card.name == name) {
                _productCards.remove(card)
                break
            }
        }
    }

    fun saveChanges(){
        val content = StringBuilder()
        for (productCard in _productCards){
            content.append("${productCard.name}%${productCard.brand}%${productCard.price}%")
            when (productCard) {
                is FoodCard -> {
                    val cal = productCard.cal
                    content.append("$cal%")
                }

                is ShoeCard -> {
                    val size = productCard.size
                    content.append("$size%")
                }

                is ApplianceCard -> {
                    val wattage = productCard.wattage
                    content.append("$wattage%")

                }
            }
            content.append("${productCard.productType}\n")

        }
        fileProductCarts.writeText(content.toString())
    }

    fun saveProductCard(productCard: ProductCard){
        _productCards.add(productCard)
    }

    private fun loadAllCards(): MutableSet<ProductCard> {

        val cards = mutableSetOf<ProductCard>()
        val content = fileProductCarts.readText().trim()

        if(!fileProductCarts.exists()) fileProductCarts.createNewFile()
        if (content.isEmpty()) return cards

        val cardsAsString = content.split("\n")
        for (cardAsString in cardsAsString) {
            val prop = cardAsString.split("%")
            val name = prop[0]
            val brand = prop[1]
            val price = prop[2].toInt()
            val type = prop.last()
            val productType = ProductType.valueOf(type)
            val productCard = when (productType) {
                ProductType.FOOD -> {
                    val cal = cardAsString[3].toInt()
                    FoodCard(name, brand, price, cal)
                }

                ProductType.APPLIANCE -> {
                    val wattage = cardAsString[3].toInt()
                    ApplianceCard(name, brand, price, wattage)

                }

                ProductType.SHOE -> {
                    val size = cardAsString[3].toInt()
                    ShoeCard(name, brand, price, size)
                }
            }
            cards.add(productCard)
        }
        return cards
    }
}