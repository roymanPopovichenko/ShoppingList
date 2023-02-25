package com.example.shoppinglist.Domain

class RemoveShopItemUseCase(val repository: ShopListRepository) {

    fun removeShopItem(shopItem: ShopItem) {
        return repository.removeShopItem(shopItem)
    }

}