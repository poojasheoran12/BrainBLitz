package com.example.brainblitz.ui

import android.util.Log
import androidx.compose.foundation.interaction.HoverInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.brainblitz.data.Question
import com.example.brainblitz.model.GameViewModel

@Composable
fun QuizScreen(viewModel: GameViewModel,
               onGameEnd: () -> Unit,
               onExit:()->Unit
               ) {
    val currentUiState by viewModel.uiState.collectAsState()

    val selectedOption =currentUiState.selectedOption
    val currentQuestion=currentUiState.currentQuestion.question
    val options = currentUiState.currentQuestion.options
    Log.d("QUIZ", "Game Over? ${currentUiState.isGameOver}")
    Log.d("QUIZ", "Score ${currentUiState.score}")
    Log.d("QUIZ", "Difficulty ${currentUiState.difficulty}")

    LaunchedEffect(currentUiState.isGameOver) {
        if (currentUiState.isGameOver) {
            onGameEnd()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Question ${currentUiState.questionNumber}",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
//        Text(
//            text = "Score: ${currentUiState.score}",
//            fontSize = 16.sp,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.align(Alignment.End)
//        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text =currentQuestion,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        QuizLayout(options = options, selected = selectedOption) { falana->
             viewModel.selectOption(falana)
        }

        Spacer(modifier = Modifier.height(32.dp))

        SkipSubmit(
            onSkip = { viewModel.onSkip() },
            onSubmit = { viewModel.checkAns() },
            enabled = selectedOption.isNotEmpty()
        )
        Spacer(modifier = Modifier.height(32.dp))

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Button(
                onExit,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
            ) {
                Text(text = "Exit")
            }
        }
    }
}

@Composable
fun QuizLayout(
    options: List<String>,
    selected: String,
    onOptionSelected: (String) -> Unit
) {
    Column {
        options.forEach { option ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                RadioButton(
                    selected = selected == option,
                    onClick = { onOptionSelected(option) }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = option)
            }
        }
    }
}

@Composable
fun SkipSubmit(
    onSkip: () -> Unit,
    onSubmit: () -> Unit,
    enabled: Boolean
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = onSkip,
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
        ) {
            Text(text = "Skip")
        }

        Button(
            onClick = onSubmit,
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
        ) {
            Text(text = "Submit")
        }
    }
}
//User taps on an option
//↓
//RadioButton onClick is triggered
//↓
//Calls onOptionSelected(option)
//↓
//Calls viewModel.selectOption(option)
//↓
//ViewModel updates selectedOption in uiState
//↓
//UI recomposes with new selected value highlighted
