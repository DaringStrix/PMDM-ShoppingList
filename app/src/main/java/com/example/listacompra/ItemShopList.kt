package com.example.listacompra

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class SampleListDataProvider : PreviewParameterProvider<MyShopList> {
    override val values = sequenceOf(MyShopList("Producto 1"))
}

@Preview(showSystemUi = true)
@Composable
fun ItemShopList(@PreviewParameter(SampleListDataProvider::class) items: MyShopList) {

    var isPurchased by rememberSaveable { mutableStateOf(false) }

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
                    checked = isPurchased,
                    onCheckedChange = { isPurchased = it }
                )

                IconButton(
                    onClick = { println("Clicked") }
                ) {
                    Icon(Icons.Filled.Close, contentDescription = "Close")
                }
            }
        }
    }
}