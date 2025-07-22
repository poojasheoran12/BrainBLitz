package com.example.brainblitz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.brainblitz.model.GameViewModel
import com.example.brainblitz.model.UnscrambleViewModel
import com.example.brainblitz.navigation.NavGraph
import com.example.brainblitz.ui.UnscrambleScreen
import com.example.brainblitz.ui.theme.BrainBLitzTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BrainBLitzTheme {
                BrainBlitzApp()
            }
        }
    }
}

@Composable
fun BrainBlitzApp(viewModel: GameViewModel = viewModel(),unscrambleViewModel: UnscrambleViewModel = viewModel()) {
    val navController = rememberNavController()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        NavGraph(navController = navController, viewModel = viewModel, unscrambleViewModel =unscrambleViewModel)
    }
}
