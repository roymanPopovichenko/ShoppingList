package com.example.shoppinglist.Domain

class AddShopItemUseCase(val repository: ShopListRepository) {

    fun addShopItem(shopItem: ShopItem) {
        return repository.addShopItem(shopItem)
    }

}