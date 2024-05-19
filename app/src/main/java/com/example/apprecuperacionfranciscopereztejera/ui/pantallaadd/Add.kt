package com.example.apprecuperacionfranciscopereztejera.ui.pantallaadd

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.apprecuperacionfranciscopereztejera.ui.ruta.Rutas

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun PantallaAdd(navController: NavController?) {

    var expanded by remember { mutableStateOf(false) }
    val items = listOf("Item 1", "Item 2", "Item 3")
    var selectedItem by remember { mutableStateOf(items[0]) }
    var marca by remember { mutableStateOf("") }
    var modelo by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(Color(red = 42, green = 42, blue = 42))
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Selecciona un tipo de vehículo",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
            color = Color.White
        )
        DropDownMenuCustom(
            expanded = expanded,
            onExpandedChange = { expanded = it },
            items = items,
            selectedItem = selectedItem,
            onItemSelected = { selectedItem = it }
        )

        Text(
            text = "Marca del vehículo",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
            color = Color.White
        )

        TextField(
            value = marca,
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 20.dp, bottom = 20.dp)
                .background(Color(red = 62, green = 62, blue = 62)))

        Text(
            text = "Modelo del vehículo",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
            color = Color.White
        )

        TextField(
            value = modelo,
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp,top = 20.dp, bottom = 20.dp)
                .background(Color(red = 62, green = 62, blue = 62)))

        Text(
            text = "Precio del vehículo",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
            color = Color.White
        )

        TextField(
            value = precio,
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 10.dp, bottom = 20.dp)
                .background(Color(red = 62, green = 62, blue = 62)))

        Button(onClick = { navController?.navigate(Rutas.PantallaHome.ruta) },
            modifier = Modifier
                .padding(start = 30.dp, end = 30.dp, top = 20.dp)
                .fillMaxWidth()
                .height(60.dp),
            shape =  RoundedCornerShape(10.dp),
            border = BorderStroke(4.dp, Color.White),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(red = 30, green = 30, blue = 30)
            )
        ) {
            Text(text = "Añadir Vehículo",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                color = Color.White)
        }

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenuCustom(
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    items: List<String>,
    selectedItem: String,
    onItemSelected: (String) -> Unit
) {
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = onExpandedChange,
    ) {
        TextField(
            value = selectedItem,
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    modifier = Modifier.rotate(if (expanded) 180f else 0f)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, bottom = 20.dp, top = 20.dp)
                .background(Color(red = 62, green = 62, blue = 62))
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { onExpandedChange(false) }
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = { Text(
                        text = item,
                        color = Color.White) },
                    onClick = {
                        onItemSelected(item)
                        onExpandedChange(false)
                    }
                )
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginPreview() {
    PantallaAdd(navController = null)
}