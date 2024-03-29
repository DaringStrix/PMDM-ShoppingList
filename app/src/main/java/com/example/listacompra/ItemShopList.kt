package com.example.listacompra

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun ShopListItem(
    items: ShopListElement,
    onClose: () -> Unit
) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start
    ) {
        Card(
            Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            backgroundColor = MaterialTheme.colors.secondary,
            elevation = 8.dp
        ) {
            Row(
                Modifier
                    .padding(15.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    items.producto,
                    Modifier
                        .weight(1F)
                        .padding(start = 16.dp),
                    fontSize = 25.sp
                )

                Checkbox(
                    checked = items.isChecked,
                    onCheckedChange = { items.isChecked = it }
                )

                IconButton(
                    onClick = onClose
                ) {
                    Icon(Icons.Filled.Close, contentDescription = "Close")
                }
            }
        }
    }
}

