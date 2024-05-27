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
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.apprecuperacionfranciscopereztejera.model.Vehicle
import com.example.apprecuperacionfranciscopereztejera.repositorio.ViewModel
import com.example.apprecuperacionfranciscopereztejera.ui.components.CardItem
import com.example.apprecuperacionfranciscopereztejera.ui.ruta.Rutas
import kotlinx.coroutines.selects.selectUnbiased

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PantallaHome(navController: NavController?, viewModel: ViewModel) {
    val selectedItems = remember { mutableStateListOf<Vehicle>() }
    var showCheckboxes by remember { mutableStateOf(false) }
    val vehicleList by viewModel.vehicleList.collectAsState()
    var searchText by remember { mutableStateOf(TextFieldValue()) }


    LaunchedEffect(Unit) {
        viewModel.getAllVehiclesFromUser()
    }

    Column(
        modifier = Modifier
            .background(Color(red = 42, green = 42, blue = 42))
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Coches de mi Garaje",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 30.sp,
            color = Color.White
        )
        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 16.dp),
            textStyle = TextStyle(color = Color.White),
            label = { Text("Buscar...", color = Color.White) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.White,
                cursorColor = Color.White,
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White,
            ),
            shape = MaterialTheme.shapes.small,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = Color.White
                )
            }
        )

        val filteredList = vehicleList?.filter {
            it.brand.equals(searchText.text, ignoreCase = true)
        } ?: emptyList()


        Button(
            enabled =selectedItems.isNotEmpty(),
            onClick = {
                if (selectedItems.isNotEmpty()) {
                    selectedItems.forEach { item ->
                        viewModel.deleteVehicleFromUser(item.id)
                    }
                    selectedItems.clear()
                    showCheckboxes = false
                }
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
            items(vehicleList?.size ?: 0) { item ->

                if (vehicleList?.size == 0) {
                    Column {
                        Text(text = "No se encuentran datos de este usuario",
                            color =  Color.White, fontSize = 20.sp)
                    }
                }

                CardItem(
                    brand = vehicleList!![item].brand,
                    modelName = vehicleList!![item].modelName,
                    price = vehicleList!![item].price,
                    imageModel = vehicleList!![item].imageModel,
                    isSelected = selectedItems.contains(vehicleList!![item]),
                    showCheckbox = showCheckboxes,
                    onClick = {
                        if (selectedItems.isEmpty()) {
                            //viewModel._idVehicleUpdate = vehicleList!![item].id
                            navController?.navigate(Rutas.PantallaVehiculo.ruta)
                        } else {
                            if (selectedItems.contains(vehicleList!![item])) {
                                selectedItems.remove(vehicleList!![item])
                            } else {
                                selectedItems.add(vehicleList!![item])
                            }
                            if (selectedItems.isEmpty()) {
                                showCheckboxes = false
                            }
                        }
                    }
                ) {
                    showCheckboxes = true
                    if (!selectedItems.contains(vehicleList!![item])) {
                        selectedItems.add(vehicleList!![item])
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginPreview() {
//    PantallaHome(navController = null, "")
}