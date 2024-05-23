package com.example.apprecuperacionfranciscopereztejera.ui.pantallanotificacion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun NotificationScreen(navController: NavController) {

    val itemList = listOf("Se borró un usuario", "Se añadio un usuario", "Se actualizó un usuario")

    LazyColumn(
        modifier = Modifier
            .background(Color(red = 42, green = 42, blue = 42))
            .fillMaxSize()
            .padding(top = 20.dp, bottom = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(itemList) { item ->

            Text(text = item)


        }
    }
}