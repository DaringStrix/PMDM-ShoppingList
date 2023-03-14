package com.example.listacompra

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Content(
    paddingValues: PaddingValues,
    showDialog: Boolean,
    shopListItems: SnapshotStateList<ShopListElement>,
    removeShopListItem: (ShopListElement) -> Unit,
    hideDialog: (Boolean) -> Unit,
    onConfirmAddElement: (String) -> Unit
) {

    Box(modifier = Modifier.padding(paddingValues)) {
        LazyColumn(
            Modifier
                .padding(top = 20.dp)
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(items = shopListItems) { element ->
                ShopListItem(
                    element,
                    onClose = {
                        removeShopListItem(element) })
            }
        }

        if (showDialog) {
            AddElementDialog(
                onConfirmAddElement = onConfirmAddElement
            ) { hideDialog(true) }
        }



    }
}