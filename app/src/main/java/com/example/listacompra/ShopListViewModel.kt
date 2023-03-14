package com.example.listacompra

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class ShopListViewModel : ViewModel() {
    private val _shoplistItems = getItemList().toMutableStateList()
    val shoplistItems: SnapshotStateList<ShopListElement>
        get() = _shoplistItems

    val showSelectAll = mutableStateOf(false)
    val selectAll =  mutableStateOf(false)
    val showDialog = mutableStateOf(false)
//    var listTitle = mutableStateOf("Select All")




    fun removeShopListItem(item: ShopListElement) {
        shoplistItems.remove(item)
    }

    fun addShopListItem(item: ShopListElement, context: Context) {
        shoplistItems.find { item.producto == it.producto }?.let {
            Toast.makeText(context, "Ese producto ya existe.", Toast.LENGTH_SHORT).show()

        } ?: shoplistItems.add(item)
    }

    fun hideDialog(boolean: Boolean) {
        showDialog.value = false
    }

    fun removeMultipleShopListItems() {
        shoplistItems.removeIf { it.isChecked }
    }
    fun isAnyChecked() = shoplistItems.any { it.isChecked }

}