package com.example.apprecuperacionfranciscopereztejera

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.apprecuperacionfranciscopereztejera.ui.navegacion.GrafoDeNavegacion
import com.example.apprecuperacionfranciscopereztejera.ui.theme.AppRecuperacionFranciscoPerezTejeraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppRecuperacionFranciscoPerezTejeraTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GrafoDeNavegacion()
                }
            }
        }
    }
}