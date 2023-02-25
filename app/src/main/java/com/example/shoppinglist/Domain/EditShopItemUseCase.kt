package com.example.shoppinglist.Domain

class EditShopItemUseCase(val repository: ShopListRepository) {

    fun editShopItem(shopItem: ShopItem) {
        return repository.editShopItem(shopItem)
    }

}