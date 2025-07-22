package com.example.brainblitz.data

import androidx.compose.ui.geometry.Offset
    import com.example.brainblitz.data.Question



data class GameUiState(
    val currentQuestion: Question = EmptyQuestion,
    val score: Int = 0,
    val selectedOption: String = "",
    val questionNumber: Int = 1,
    val difficulty: String = "Easy",
    val isGameOver: Boolean = false
)