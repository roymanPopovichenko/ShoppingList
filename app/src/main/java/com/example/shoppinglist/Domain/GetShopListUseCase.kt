package com.example.shoppinglist.Domain

import androidx.lifecycle.LiveData

class GetShopListUseCase(val repository: ShopListRepository) {

    fun getShopList(): LiveData<List<ShopItem>> {
        return repository.getShopList()
    }

}