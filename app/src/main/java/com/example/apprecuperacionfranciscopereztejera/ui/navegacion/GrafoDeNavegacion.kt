package com.example.apprecuperacionfranciscopereztejera.ui.navegacion

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.apprecuperacionfranciscopereztejera.R
import com.example.apprecuperacionfranciscopereztejera.ui.components.AppBar
import com.example.apprecuperacionfranciscopereztejera.ui.components.CardItem
import com.example.apprecuperacionfranciscopereztejera.ui.components.DrawerBody
import com.example.apprecuperacionfranciscopereztejera.ui.components.DrawerHeader
import com.example.apprecuperacionfranciscopereztejera.ui.components.MenuItem
import com.example.apprecuperacionfranciscopereztejera.ui.nuevousuario.PantallaNuevoUsuario
import com.example.apprecuperacionfranciscopereztejera.ui.pantallaadd.PantallaAdd
import com.example.apprecuperacionfranciscopereztejera.ui.pantallahome.PantallaHome
import com.example.apprecuperacionfranciscopereztejera.ui.pantallalogin.PantallaLogin
import com.example.apprecuperacionfranciscopereztejera.ui.ruta.Rutas
import kotlinx.coroutines.launch

@SuppressLint(
    "UnusedMaterial3ScaffoldPaddingParameter", "ComposableDestinationInComposeScope",
    "SuspiciousIndentation", "UnusedMaterialScaffoldPaddingParameter"
)
@Composable
fun GrafoDeNavegacion() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val currentDestination = navController.currentBackStackEntryAsState().value?.destination?.route
    val showScaffold = currentDestination != Rutas.PantallaLogin.ruta && currentDestination != Rutas.PantallaNuevoUsuario.ruta

    if (showScaffold) {
        Scaffold(
            modifier = Modifier.background(Color(red = 42, green = 42, blue = 42)),
            scaffoldState = scaffoldState,
            topBar = {
                AppBar(
                    onNavigationIconClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }
                )
            },
            drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
            drawerContent = {
                Column(
                    modifier = Modifier
                        .background(Color(red = 42, green = 42, blue = 42))
                        .fillMaxSize()
                ) {
                    DrawerHeader()
                    DrawerBody(
                        items = listOf(
                            MenuItem(
                                id = "home",
                                title = "Home",
                                contentDescription = "Go to home screen",
                                icon = Icons.Default.Home
                            ),
                            MenuItem(
                                id = "get",
                                title = "Garaje",
                                contentDescription = "Go to settings garage screen",
                                icon = Icons.Default.Warning
                            ),
                            MenuItem(
                                id = "push",
                                title = "Añadir vehículo",
                                contentDescription = "Go to Add vehicle",
                                icon = Icons.Default.Add
                            ),
                            MenuItem(
                                id = "close",
                                title = "Cerrar sesión",
                                contentDescription = "Close session",
                                icon = Icons.Default.ExitToApp
                            ),
                        ),
                        onItemClick = {
                            when (it.id) {
                                "home" -> navController.navigate(Rutas.PantallaHome.ruta)
                                "get" -> navController.navigate(Rutas.PantallaHome.ruta)
                                "close" -> navController.navigate(Rutas.PantallaLogin.ruta)
                                "push" -> navController.navigate(Rutas.PantallaAdd.ruta)
                            }
                            scope.launch {
                                scaffoldState.drawerState.close()
                            }
                        }
                    )
                }
            },
            bottomBar = {
                Row(
                    modifier = Modifier
                        .background(Color(red = 30, green = 30, blue = 30))
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { navController.navigate(Rutas.PantallaHome.ruta) }) {
                        Icon(
                            painter = painterResource(id = R.drawable.icons8_casa_24__1_),
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                    IconButton(onClick = { navController.navigate(Rutas.PantallaAdd.ruta) }) {
                        Icon(
                            painter = painterResource(id = R.drawable.icons8_a_adir_30),
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.icons8_recordatorios_de_citas_24),
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            },
            content = {
                NavHost(navController = navController, startDestination = Rutas.PantallaLogin.ruta) {
                    composable(Rutas.PantallaLogin.ruta) {
                        PantallaLogin(navController = navController)
                    }
                    composable(Rutas.PantallaNuevoUsuario.ruta) {
                        PantallaNuevoUsuario(navController = navController)
                    }
                    composable(Rutas.PantallaHome.ruta) {
                        PantallaHome(navController = navController)
                    }
                    composable(Rutas.PantallaAdd.ruta) {
                        PantallaAdd(navController = navController)
                    }
                }
            }
        )
    } else {
        NavHost(navController = navController, startDestination = Rutas.PantallaLogin.ruta) {
            composable(Rutas.PantallaLogin.ruta) {
                PantallaLogin(navController = navController)
            }
            composable(Rutas.PantallaNuevoUsuario.ruta) {
                PantallaNuevoUsuario(navController = navController)
            }
            composable(Rutas.PantallaHome.ruta) {
                PantallaHome(navController = navController)
            }
            composable(Rutas.PantallaAdd.ruta) {
                PantallaAdd(navController = navController)
            }
        }
    }
}
