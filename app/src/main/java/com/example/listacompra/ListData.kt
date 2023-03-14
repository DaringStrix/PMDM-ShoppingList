package com.example.listacompra

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


class ShopListElement(val producto: String){
    var isChecked by mutableStateOf(false)
}

fun getItemList() = listOf(
    ShopListElement(
        "Producto 1"
    ),
    ShopListElement(
        "Producto 2"
    ),
    ShopListElement(
        "Producto 3"
    ),
    ShopListElement(
        "Producto 4"
    ),
    ShopListElement(
        "Producto 5"
    )
)