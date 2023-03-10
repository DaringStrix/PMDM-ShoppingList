package com.example.listacompra.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.listacompra.DeleteElement

@Composable
fun DeleteFAB(remove: () -> Unit) {
    val delete = remember { mutableStateOf(false) }

    Column(
        Modifier
            .fillMaxHeight()
            .padding(15.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FloatingActionButton(
            onClick = { delete.value = true }
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete item"
            )
        }
        if (delete.value) {
            DeleteElement(onConfirmDeleteElement = remove) { delete.value = false }
        }
    }
}

@Composable
fun AddFAB(showDialog: MutableState<Boolean>) {

    FloatingActionButton(
        onClick = { showDialog.value = true }
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add item"
        )
    }

}