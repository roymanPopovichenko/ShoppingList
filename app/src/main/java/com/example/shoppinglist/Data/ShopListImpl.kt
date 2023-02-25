package com.example.shoppinglist.Data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoppinglist.Domain.ShopItem
import com.example.shoppinglist.Domain.ShopListRepository
import java.util.SortedSet

class ShopListImpl: ShopListRepository {

    private var shopListLD = MutableLiveData<List<ShopItem>>()
    private var shopList = sortedSetOf<ShopItem>({ p0, p1 -> p0.id.compareTo(p1.id) })

    private var generatedId = 0

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find { it.id == shopItemId } ?: throw RuntimeException("ID WAS NOT FOUND")
    }

    override fun removeShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        update()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id =  generatedId++
        }
        shopList.add(shopItem)
        update()
    }

    fun update() {
        shopListLD.value = shopList.toList()
    }

}