package com.example.brainblitz.navigation


import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


import androidx.navigation.NavHostController

import androidx.navigation.compose.rememberNavController
import com.example.brainblitz.ui.HomeScreen
import com.example.brainblitz.ui.QuizScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.brainblitz.model.GameViewModel
import com.example.brainblitz.model.UnscrambleViewModel
import com.example.brainblitz.ui.DifficultyScreen
import com.example.brainblitz.ui.ResultScreen
import com.example.brainblitz.ui.UnscrambleScreen


enum class Screen(val route: String) {
    Home("home"),
    Quiz("quiz"),
    Math("math"),
    Memory("memory"),
    Unscramble("unscramble"),
    Flags("flags"),
    QuizDifficulty("quizDifficulty"),
    Result("result"),
}



@Composable
fun NavGraph(navController: NavHostController = rememberNavController(),viewModel: GameViewModel,unscrambleViewModel: UnscrambleViewModel) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(Screen.Home.route) {
            HomeScreen { route -> navController.navigate(route) }
        }


        composable(Screen.QuizDifficulty.route) {

            DifficultyScreen(
                viewModel = viewModel,
                onPlay = { viewModel.resetGame()
                    navController.navigate(Screen.Quiz.route) },
                onExit = { navController.navigate(Screen.Home.route) }
            )
        }

        composable(Screen.Quiz.route) {

            QuizScreen(viewModel = viewModel,{navController.navigate(Screen.Result.route)},{navController.navigate(Screen.Home.route)})
        }
        composable (Screen.Unscramble.route){
            UnscrambleScreen(unscrambleViewModel)

        }

        composable(Screen.Result.route) {
            val uiState by viewModel.uiState.collectAsState()

            ResultScreen(
                viewModel = viewModel,
                score = uiState.score,
                total = uiState.questionNumber,
                onPlayAgain = {
                    navController.navigate(Screen.QuizDifficulty.route)

                 },
                onExit = {
                    navController.navigate(Screen.Home.route) }
            )
        }
    }
}


