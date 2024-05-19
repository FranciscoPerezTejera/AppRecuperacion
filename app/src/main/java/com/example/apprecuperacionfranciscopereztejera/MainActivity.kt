package com.example.apprecuperacionfranciscopereztejera

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.apprecuperacionfranciscopereztejera.ui.components.AppBar
import com.example.apprecuperacionfranciscopereztejera.ui.components.DrawerBody
import com.example.apprecuperacionfranciscopereztejera.ui.components.DrawerHeader
import com.example.apprecuperacionfranciscopereztejera.ui.components.MenuItem
import com.example.apprecuperacionfranciscopereztejera.ui.navegacion.GrafoDeNavegacion
import com.example.apprecuperacionfranciscopereztejera.ui.theme.AppRecuperacionFranciscoPerezTejeraTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint(
        "UnusedMaterial3ScaffoldPaddingParameter",
        "UnusedMaterialScaffoldPaddingParameter"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppRecuperacionFranciscoPerezTejeraTheme {

                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    GrafoDeNavegacion()
                }
            }
        }
    }
}
