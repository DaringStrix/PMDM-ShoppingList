package com.example.listacompra


import java.time.LocalTime

data class MyShopList(
    val producto: String,
)

val items: List<MyShopList> = listOf(
    MyShopList(
        "Producto 1"
    ),
    MyShopList(
        "Producto 2"
    ),
    MyShopList(
        "Producto 3"
    ),
    MyShopList(
        "Producto 4"
    ),
    MyShopList(
        "Producto 5"
    )
)