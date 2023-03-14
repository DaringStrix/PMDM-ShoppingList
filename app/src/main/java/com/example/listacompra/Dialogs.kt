package com.example.listacompra

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import kotlinx.coroutines.delay

@Composable
fun AddElementDialog(
    onConfirmAddElement: (String) -> Unit,
    onDismiss: () -> Unit
) {
    var defaultName by remember { mutableStateOf("") }
    val focusRequester = FocusRequester()
    AlertDialog(
        title = { Text(text = "Add new element") },
        text = {
            TextField(
                value = defaultName,
                onValueChange = { itemName -> defaultName = itemName },
            Modifier.focusRequester(focusRequester))
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
    LaunchedEffect(Unit) {
        delay(100)
        focusRequester.requestFocus()
    }
}

@Composable
fun DeleteElementDialog(
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