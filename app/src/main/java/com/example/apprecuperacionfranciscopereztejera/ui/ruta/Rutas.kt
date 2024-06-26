package com.example.apprecuperacionfranciscopereztejera.ui.ruta

sealed class Rutas (val ruta : String) {
    object PantallaLogin : Rutas("pantallaLogin")
    object PantallaNuevoUsuario : Rutas("pantallanuevousuario")
    object PantallaHome : Rutas("pantallahome")
    object PantallaAdd : Rutas("pantallaadd")
    object PantallaVehiculo : Rutas("pantallavehiculo")

    object PantallaUsuarioEdit : Rutas("pantallausuarioedit")

}