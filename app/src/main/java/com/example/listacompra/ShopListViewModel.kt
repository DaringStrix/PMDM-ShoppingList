package com.example.listacompra

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class ShopListViewModel : ViewModel() {
    private val _shoplistItems = getItemList().toMutableStateList()
    val shoplistItems: SnapshotStateList<ShopListElement>
        get() = _shoplistItems


    fun removeShopListItem(item: ShopListElement){shoplistItems.remove(item)}
}