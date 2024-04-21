package com.example.apprecuperacionfranciscopereztejera.ui.pantallahome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PantallaHome(navController: NavController?) {

    Column (
        modifier = Modifier
            .background(Color(red = 42, green = 42, blue = 42))
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {}

}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginPreview() {
    PantallaHome(navController = null)
}