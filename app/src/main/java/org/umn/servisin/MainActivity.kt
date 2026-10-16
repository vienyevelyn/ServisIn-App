package org.umn.servisin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.umn.servisin.navigation.SetupNavGraph
import org.umn.servisin.ui.theme.ServisinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ServisinTheme {
                SetupNavGraph()
            }
        }
    }
}