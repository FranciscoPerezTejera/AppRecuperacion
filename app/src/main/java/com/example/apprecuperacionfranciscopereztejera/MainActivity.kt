package com.example.apprecuperacionfranciscopereztejera

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apprecuperacionfranciscopereztejera.repositorio.ViewModel
import com.example.apprecuperacionfranciscopereztejera.ui.navegacion.GrafoDeNavegacion
import com.example.apprecuperacionfranciscopereztejera.ui.theme.AppRecuperacionFranciscoPerezTejeraTheme

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
                    val viewModel: ViewModel = viewModel()
                    GrafoDeNavegacion(viewModel)
                }
            }
        }
    }
}
