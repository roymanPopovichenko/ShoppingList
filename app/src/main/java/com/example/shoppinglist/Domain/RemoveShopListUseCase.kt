package com.example.shoppinglist.Domain

class RemoveShopListUseCase(val repository: ShopListRepository) {

    fun removeShopItem(shopItem: ShopItem) {
        return repository.removeShopItem(shopItem)
    }

}