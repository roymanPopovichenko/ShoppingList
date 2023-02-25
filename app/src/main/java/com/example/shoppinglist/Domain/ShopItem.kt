package com.example.shoppinglist.Domain

data class ShopItem(
    val name: String,
    val count: Int,
    val enabled: Boolean,
    var id: Int = UNDEFINED_ID
) {

    companion object {
        val UNDEFINED_ID = -1
    }

}