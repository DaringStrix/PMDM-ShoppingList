package com.example.listacompra

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel

class ShopListViewModel : ViewModel() {
    private val _shoplistItems = getItemList().toMutableStateList()
    val shoplistItems: SnapshotStateList<ShopListElement>
        get() = _shoplistItems


    fun removeShopListItem(item: ShopListElement){shoplistItems.remove(item)}
    fun addShopListItem(item: ShopListElement, context: Context){/*
        if (!onlist(item)) shoplistItems.add(item)*/

            shoplistItems.find { item.producto == it.producto }?.let { Toast.makeText(context ,"Ese producto ya existe.", Toast.LENGTH_SHORT ).show()
                println("toast")} ?: shoplistItems.add(item)


    }

}