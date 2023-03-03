package com.example.listacompra

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@Preview(showSystemUi = true)
@Composable
fun Principal() {
    Scaffold(
        scaffoldState = rememberScaffoldState(),
        topBar = {
            TopAppBar(title = {
                Text(stringResource(R.string.titulo))
            })
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            Row(
                Modifier
                    .fillMaxWidth().padding(top = 10.dp)
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
                items(items) { shopList -> ItemShopList(shopList) }
            }
        }
    }
}

