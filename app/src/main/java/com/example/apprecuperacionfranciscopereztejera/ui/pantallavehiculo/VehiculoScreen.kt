package com.example.apprecuperacionfranciscopereztejera.ui.pantallavehiculo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.apprecuperacionfranciscopereztejera.model.Vehicle
import com.example.apprecuperacionfranciscopereztejera.repositorio.ViewModel
import com.example.apprecuperacionfranciscopereztejera.ui.ruta.Rutas

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VehiculoScreen(navController: NavController, viewModel: ViewModel) {

    var expanded by remember { mutableStateOf(false) }
    val items = listOf("Item 1", "Item 2", "Item 3")
    var selectedItem by remember { mutableStateOf(items[0]) }
    var precio by remember { mutableStateOf("") }
    var vehicle: Vehicle? = null

    /*LaunchedEffect(Unit) {
        vehicle = viewModel.getVehicleById()
    }*/

    LazyColumn(
        modifier = Modifier
            .background(Color(red = 42, green = 42, blue = 42))
            .fillMaxSize()
            .padding(top  = 20.dp,bottom = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        item {
            Text(
                text = "Marca del vehículo",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                color = Color.White
            )
            TextField(
                value = "vehicle!!.brand",
                onValueChange = { "vehicle!!.brand = it" },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp, top = 20.dp, bottom = 20.dp)
                    .background(Color(red = 62, green = 62, blue = 62))
            )
        }
        item {
            Text(
                text = "Modelo del vehículo",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                color = Color.White
            )
            TextField(
                value = "vehicle!!.modelName",
                onValueChange = { "vehicle!!.modelName = it" },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp, top = 20.dp, bottom = 20.dp)
                    .background(Color(red = 62, green = 62, blue = 62))
            )
        }
        /*precio = vehicle!!.price.toString()
        item {
            Text(
                text = "Precio del vehículo",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                color = Color.White
            )
            TextField(
                value = precio,
                onValueChange = { precio = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp, top = 10.dp, bottom = 20.dp)
                    .background(Color(red = 62, green = 62, blue = 62))
            )
        }*/
        item {
            Text(
                text = "Imagen del vehículo",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                color = Color.White
            )
            TextField(
                value = "vehicle!!.imageModel",
                onValueChange = { "vehicle!!.imageModel = it" },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp, top = 10.dp, bottom = 20.dp)
                    .background(Color(red = 62, green = 62, blue = 62))
            )
        }
        item {
            Button(
                onClick = {
                    //viewModel.updateVehicleFromUser(vehicle!!.id, vehicle!!)
                    navController?.navigate(Rutas.PantallaHome.ruta)
                          },
                modifier = Modifier
                    .padding(start = 30.dp, end = 30.dp, top = 20.dp)
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(4.dp, Color.White),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(red = 30, green = 30, blue = 30)
                )
            ) {
                Text(
                    text = "Añadir Vehículo",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
        }
    }
}