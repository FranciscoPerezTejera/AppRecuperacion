package com.example.apprecuperacionfranciscopereztejera.ui.pantallalogin

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.apprecuperacionfranciscopereztejera.R
import com.example.apprecuperacionfranciscopereztejera.model.User
import com.example.apprecuperacionfranciscopereztejera.repositorio.ViewModel
import com.example.apprecuperacionfranciscopereztejera.ui.ruta.Rutas

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaLogin(navController: NavController?, viewModel: ViewModel) {
        var user by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        val userList by viewModel.userList.collectAsState()
        val estate by viewModel.estadoLlamada.collectAsState()
        var usuarioEncontrado by remember { mutableStateOf(false) }
        var usuario by remember { mutableStateOf<User?>(null) }

        Column(
                modifier = Modifier
                        .background(Color(red = 42, green = 42, blue = 42))
                        .fillMaxSize()
                        .padding(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
        ) {
                Image(
                        painter = painterResource(id = R.drawable.logazo),
                        contentDescription = "Logo de CarServicePro",
                        modifier = Modifier.size(300.dp)
                )
                Text(
                        text = "CarServicePro",
                        fontSize = 48.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                        text = "Administra tu garaje de vehiculos desde tu móvil",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                        value = user,
                        onValueChange = { user = it },
                        label = { Text("Usuario", color = Color.White) },
                        placeholder = { Text("Usuario", color = Color.White) },
                        modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .clip(RoundedCornerShape(5.dp)),
                        textStyle = TextStyle(color = Color.White),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color.White,
                                unfocusedBorderColor = Color.Gray
                        )
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Contraseña", color = Color.White) },
                        placeholder = { Text("Contraseña", color = Color.White) },
                        modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .clip(RoundedCornerShape(5.dp)),
                        textStyle = TextStyle(color = Color.White),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color.White,
                                unfocusedBorderColor = Color.Gray
                        )
                )
                Spacer(modifier = Modifier.height(16.dp))

                Button(
                        onClick = {
                                usuario = userList?.find { it.email == user }
                                usuarioEncontrado = userList!!.any { it.email == user}
                                viewModel._user = usuario
                                Log.e("USUARIO", viewModel._user.toString())
                                /*if (usuario != null) {
                                        val correcta: Boolean = viewModel.checkPassword(usuario!!.password)
                                }*/
                                if (usuarioEncontrado) {
                                        navController?.navigate(Rutas.PantallaHome.ruta)
                                }
                                  },
                        modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .clip(RoundedCornerShape(10.dp)),
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(Color(104, 104, 104))
                ) {
                        Text(
                                text = "Log In",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                        )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                ) {
                        Text(text = "¿Nuevo en miaplicación?", color = Color.White)
                        TextButton(onClick = { navController?.navigate(Rutas.PantallaNuevoUsuario.ruta) }) {
                                Text(text = "Registrarse")
                        }
                }
        }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginPreview() {
       // PantallaLogin(navController = null)
}
