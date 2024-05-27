package com.example.apprecuperacionfranciscopereztejera.ui.pantallaadd

import android.util.Log
import android.widget.Toast
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
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.apprecuperacionfranciscopereztejera.model.Vehicle
import com.example.apprecuperacionfranciscopereztejera.repositorio.ViewModel
import com.example.apprecuperacionfranciscopereztejera.ui.ruta.Rutas

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun PantallaAdd(navController: NavController?, viewModel: ViewModel) {

    var marca by remember { mutableStateOf("") }
    var modelo by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var imageModel by remember { mutableStateOf("") }

    val clipboardManager: ClipboardManager = LocalClipboardManager.current
    val context = LocalContext.current

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
            OutlinedTextField(
                value = marca,
                onValueChange = { marca = it },
                placeholder = { Text("Marca del vehiculo", color = Color.White) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp, top = 10.dp, bottom = 20.dp),
                textStyle = TextStyle(
                    color = Color.White,
                    textAlign = TextAlign.Center),
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.Gray
                )
            )
        }
        item {
            Text(
                text = "Modelo del vehículo",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                color = Color.White
            )
            OutlinedTextField(
                value = modelo,
                onValueChange = { modelo = it },
                placeholder = { Text("Marca del vehiculo", color = Color.White) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp, top = 10.dp, bottom = 20.dp),
                textStyle = TextStyle(
                    color = Color.White,
                    textAlign = TextAlign.Center),
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.Gray
                )
            )
        }
        item {
            Text(
                text = "Precio del vehículo",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                color = Color.White
            )
            OutlinedTextField(
                value = precio,
                onValueChange = { precio = it },
                placeholder = { Text("Marca del vehiculo", color = Color.White) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp, top = 10.dp, bottom = 20.dp),
                textStyle = TextStyle(
                    color = Color.White,
                    textAlign = TextAlign.Center),
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.Gray
                )
            )
        }
        item {
            Text(
                text = "Imagen del vehículo",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                color = Color.White
            )
            OutlinedTextField(
                enabled = false,
                value = "https://img.freepik.com/vector-premium/caracter-cara-coche-divertido-emoticon-coche-rojo-sonrie-iconos-ilustracion-vectorial_55610-8973.jpg",
                onValueChange = {  },
                placeholder = { Text("Marca del vehiculo", color = Color.White) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp, top = 10.dp, bottom = 20.dp),
                textStyle = TextStyle(
                    color = Color.White,
                    textAlign = TextAlign.Center),
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.Gray
                ),
                trailingIcon = {
                    IconButton(onClick = {
                        val clipboardText = clipboardManager.getText()
                        if (clipboardText != null) {
                            imageModel = clipboardText.text
                            Toast.makeText(context, "Texto Pegago", Toast.LENGTH_SHORT)
                        } else {
                            Toast.makeText(context, "Portapapeles vacío", Toast.LENGTH_SHORT)
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Paste Icon",
                            tint = Color.White
                        )
                    }
                }
            )
        }
        item {
            Button(
                onClick = {
                    /*if (imageModel == null || imageModel == "") {
                        imageModel = "https://img.freepik.com/vector-premium/caracter-cara-coche-divertido-emoticon-coche-rojo-sonrie-iconos-ilustracion-vectorial_55610-8973.jpg"
                    }*/
                    var vehiculo = viewModel.newVehicle(marca, modelo, precio.toDouble(), imageModel)

                    if (vehiculo != null) {
                        viewModel.addVehicleToUser(vehiculo)
                    }
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

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginPreview() {
  //  PantallaAdd(navController = null, 0, "")
}