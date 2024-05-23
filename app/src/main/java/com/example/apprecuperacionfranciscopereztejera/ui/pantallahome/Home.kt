package com.example.apprecuperacionfranciscopereztejera.ui.pantallahome

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.apprecuperacionfranciscopereztejera.ui.components.CardItem
import com.example.apprecuperacionfranciscopereztejera.ui.ruta.Rutas

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PantallaHome(navController: NavController?) {
    val itemList = remember { mutableStateListOf(1, 2, 3, 4, 5) }
    val selectedItems = remember { mutableStateListOf<Int>() }
    var showCheckboxes by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .background(Color(red = 42, green = 42, blue = 42))
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Coches de mi Garaje",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 30.sp,
            color = Color.White
        )
        Button(
            enabled =selectedItems.isNotEmpty(),
            onClick = {
                // Aquí puedes realizar la acción de eliminación
                itemList.removeAll(selectedItems)
                selectedItems.clear()
                showCheckboxes = false
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 60.dp)
        ) {
            items(itemList.size) { index ->
                val item = itemList[index]
                CardItem(
                    item = item,
                    isSelected = selectedItems.contains(item),
                    showCheckbox = showCheckboxes,
                    onClick = {
                        if (selectedItems.isEmpty()) {
                            navController?.navigate(Rutas.PantallaVehiculo.ruta)
                        } else {
                            if (selectedItems.contains(item)) {
                                selectedItems.remove(item)
                            } else {
                                selectedItems.add(item)
                            }
                            if (selectedItems.isEmpty()) {
                                showCheckboxes = false
                            }
                        }
                    },
                    onLongClick = {
                        showCheckboxes = true
                        if (!selectedItems.contains(item)) {
                            selectedItems.add(item)
                        }
                    }
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginPreview() {
    PantallaHome(navController = null)
}