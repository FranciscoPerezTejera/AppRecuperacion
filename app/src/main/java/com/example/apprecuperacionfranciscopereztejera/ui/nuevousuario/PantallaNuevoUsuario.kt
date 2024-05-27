package com.example.apprecuperacionfranciscopereztejera.ui.nuevousuario

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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.apprecuperacionfranciscopereztejera.R
import com.example.apprecuperacionfranciscopereztejera.model.UserDTO
import com.example.apprecuperacionfranciscopereztejera.repositorio.ViewModel
import com.example.apprecuperacionfranciscopereztejera.ui.ruta.Rutas

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaNuevoUsuario(navController: NavController?, viewModel: ViewModel) {

    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var passwordRepeat by remember { mutableStateOf("") }
    var checkedState by remember { mutableStateOf(false) }

    Column (
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
            modifier = Modifier.size(150.dp)
        )
        Text(
            text = "Nueva cuenta de usuario",
            fontSize = 28.sp,
            textAlign = TextAlign.Justify,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Correo electrónico", color = Color.White) },
            placeholder = { Text("Email", color = Color.White) },
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
        OutlinedTextField(
            value = passwordRepeat,
            onValueChange = { passwordRepeat = it },
            label = { Text("Repetir Contraseña", color = Color.White) },
            placeholder = { Text("Repetir Contraseña", color = Color.White) },
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
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Checkbox(
                checked = checkedState,
                onCheckedChange = { isChecked ->
                    checkedState = isChecked
                },
                modifier =
                Modifier.padding(end = 16.dp)
            )
            Text(text = "Pulsando aquí, aceptas los términos y condiciones de CarServicePro",
                color = Color.White,
                textAlign = TextAlign.Start,
                fontSize = 15.sp)
        }
        Spacer(modifier = Modifier.height(30.dp))
        val user = null
        Button(
            onClick = {
                var user = UserDTO(email, password)
                viewModel.addUser(user)
                navController?.navigate(Rutas.PantallaLogin.ruta) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .clip(RoundedCornerShape(10.dp)),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(Color(104, 104, 104))) {
            Text(text = "Crear Cuenta", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }

    }

}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginPreview() {
    //PantallaNuevoUsuario(navController = null)
}