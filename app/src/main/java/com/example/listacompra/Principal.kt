package com.example.listacompra

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.listacompra.ui.theme.AddFAB
import com.example.listacompra.ui.theme.DeleteFAB


@Preview(showSystemUi = true)
@Composable
fun Principal() {
    val context = LocalContext.current
    val viewModel: ShopListViewModel = viewModel()

    Scaffold(
        scaffoldState = rememberScaffoldState(),
        topBar = {
            TopAppBar(title = {
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Text(stringResource(R.string.titulo), Modifier.weight(1F))
//                    BasicTextField(value = viewModel.listTitle, onValueChange = {viewModel.listTitle = it})
                    if (viewModel.showSelectAll.value) {

                        Text(text = "Select All", fontSize = 10.sp)

                        Checkbox(
                            checked = viewModel.selectAll.value,
                            onCheckedChange = { checked ->
                                viewModel.selectAll.value = checked
                                viewModel.shoplistItems.forEach { it.isChecked = checked }
                            })
                    }
                }
            })
        },
        floatingActionButton = {
            AddFAB(showDialog = viewModel.showDialog)
        }
    ) { paddingValues ->
        Content(
            paddingValues = paddingValues,
            showDialog = viewModel.showDialog.value,
            shopListItems = viewModel.shoplistItems,
            removeShopListItem = { element -> viewModel.removeShopListItem(element)},
            hideDialog = {viewModel.hideDialog(it)}
        ) { newElement -> viewModel.addShopListItem(ShopListElement(newElement), context) }

        if (viewModel.isAnyChecked()) {
            viewModel.showSelectAll.value = true;
            DeleteFAB {
                viewModel.removeMultipleShopListItems()
            }
        }else viewModel.showSelectAll.value = false;
    }
}


