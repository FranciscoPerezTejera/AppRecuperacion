package com.example.apprecuperacionfranciscopereztejera.ui.pantallausuarioedit

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.example.apprecuperacionfranciscopereztejera.repositorio.ViewModel
import com.example.apprecuperacionfranciscopereztejera.ui.ruta.Rutas

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaEditUsuario(navController: NavController, viewModel: ViewModel) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repeatPassword by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
            .background(Color(red = 42, green = 42, blue = 42))
            .fillMaxSize()
            .padding(top = 20.dp, bottom = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item {
            Text(
                text = "introduce el email",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                color = Color.White
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text(" Introduce email", color = Color.White) },
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
                text = "Nueva Contraseña",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                color = Color.White
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("Introduce la nueva contraseña", color = Color.White) },
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
                text = "Repita Contraseña",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                color = Color.White
            )
            OutlinedTextField(
                value = repeatPassword,
                onValueChange = { repeatPassword = it },
                placeholder = { Text("Repetir Contraseña", color = Color.White) },
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
            Button(
                onClick = {
                    if (password == repeatPassword) {
                        viewModel.updateUser(email, password)
                        navController?.navigate(Rutas.PantallaHome.ruta)
                    } else {
                        showDialog = true
                    }
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
                    text = "Actualizar Usuario",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
        }
    }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Aceptar")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Cancelar")
                }
            },
            title = {
                Text("Error")
            },
            text = {
                Text("as contraseñas no coincide o hay algun error.")
            },
            properties = DialogProperties(dismissOnClickOutside = false)
        )
    }
}