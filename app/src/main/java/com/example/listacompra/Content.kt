package com.example.listacompra

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.listacompra.ui.theme.DeleteFAB
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun Content(paddingValues: PaddingValues, showDialog: MutableState<Boolean>, context: Context) {

    val viewModel: ShopListViewModel = viewModel()

    Box(modifier = Modifier.padding(paddingValues)) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .background(Color.LightGray),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")))
        }

        LazyColumn(
            Modifier
                .padding(top = 20.dp)
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(items = viewModel.shoplistItems) { element ->
                ShopListItem(
                    element,
                    onClose = { viewModel.removeShopListItem(element) })
            }
        }

        if (showDialog.value) {
            AddElement(
                onConfirmAddElement = { viewModel.addShopListItem(ShopListElement(it), context) }
            ) { showDialog.value = false }
        }

        if (viewModel.isPurchased()) {
            DeleteFAB {
                viewModel.removeMultipleShopListItems()
            }
        }
    }
}