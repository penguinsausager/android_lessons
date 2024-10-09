package com.example.myapplication.corporation

import java.io.File

object ProductCardsRepository {

    private val fileProductCarts = File("product_cards.txt")
    val productCards = loadAllCards()

    fun removeProductCard(name: String) {
        for (card in productCards) {
            if (card.name == name) {
                productCards.remove(card)
                break
            }
        }
    }

    fun showAllItems() {
        val cards = productCards
        for (card in cards) {
            card.printInfo()
        }
    }

    fun saveChanges(){
        val content = StringBuilder()
        for (productCard in productCards){
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
        productCards.add(productCard)
    }

    private fun loadAllCards(): MutableList<ProductCard> {

        val cards: MutableList<ProductCard> = mutableListOf()
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