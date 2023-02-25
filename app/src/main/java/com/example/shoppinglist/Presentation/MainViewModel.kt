package com.example.shoppinglist.Presentation

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.Data.ShopListImpl
import com.example.shoppinglist.Domain.EditShopItemUseCase
import com.example.shoppinglist.Domain.GetShopListUseCase
import com.example.shoppinglist.Domain.RemoveShopItemUseCase
import com.example.shoppinglist.Domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val removeShopItemUseCase = RemoveShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun removeShopItem(shopItem: ShopItem) {
        removeShopItemUseCase.removeShopItem(shopItem)
    }

    fun editShopItem(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }

}