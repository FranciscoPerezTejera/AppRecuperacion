package com.example.apprecuperacionfranciscopereztejera.ui.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.apprecuperacionfranciscopereztejera.ui.nuevousuario.PantallaNuevoUsuario
import com.example.apprecuperacionfranciscopereztejera.ui.pantallahome.PantallaHome
import com.example.apprecuperacionfranciscopereztejera.ui.pantallalogin.PantallaLogin
import com.example.apprecuperacionfranciscopereztejera.ui.ruta.Rutas

@Composable
fun GrafoDeNavegacion() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Rutas.PantallaLogin.ruta) {

        composable(Rutas.PantallaLogin.ruta) {
            PantallaLogin(navController =  navController)
        }
        composable(Rutas.PantallaNuevoUsuario.ruta) {
            PantallaNuevoUsuario(navController = navController)
        }
        composable(Rutas.PantallaHome.ruta) {
            PantallaHome(navController = navController)
        }
    }

}