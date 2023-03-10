package com.example.listacompra

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*

@Composable
fun AddElement(
    onConfirmAddElement: (String) -> Unit,
    onDismiss: () -> Unit
) {
    var defaultName by remember { mutableStateOf("") }

    AlertDialog(
        title = { Text(text = "Add new element") },
        text = {
            TextField(
                value = defaultName,
                onValueChange = { itemName -> defaultName = itemName })
        },
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = { // (4)
                onConfirmAddElement(defaultName)
                onDismiss()
            }) {
                Text(text = "Confirmar")
            }
        },
        dismissButton = {
            TextButton(onClick = {
                onDismiss()
            }) {
                Text(text = "Cancelar")
            }
        }
    )
}

@Composable
fun DeleteElement(
    onConfirmDeleteElement: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        title = { Text(text = "Delete this elements?") },
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = { // (4)
                onConfirmDeleteElement()
                onDismiss()
            }) {
                Text(text = "Confirmar")
            }
        },
        dismissButton = {
            TextButton(onClick = {
                onDismiss()
            }) {
                Text(text = "Cancelar")
            }
        }
    )
}