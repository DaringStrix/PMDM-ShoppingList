package com.example.listacompra

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.listacompra.ui.theme.AddFAB


@Preview(showSystemUi = true)
@Composable
fun Principal() {
    val showDialog = remember { mutableStateOf(false) }
    val context = LocalContext.current
    Scaffold(
        scaffoldState = rememberScaffoldState(),
        topBar = {
            TopAppBar(title = {
                Text(stringResource(R.string.titulo))
            })
        },
        floatingActionButton = {
            AddFAB(showDialog = showDialog)
        }
    ) { paddingValues ->
        Content(paddingValues, showDialog, context)
    }
}


