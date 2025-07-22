package com.example.brainblitz.ui

import android.app.ApplicationStartInfo
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.example.brainblitz.model.GameViewModel
import kotlin.math.roundToInt

@Composable
fun DifficultyScreen(
    viewModel: GameViewModel,
    onPlay: () -> Unit,
    onExit: () -> Unit
) {
    val currentUiState by viewModel.uiState.collectAsState()
    val offsetX = viewModel.offsetX.collectAsState().value

    val selectedDifficulty = when {
        offsetX < -80f -> "Easy"
        offsetX > 80f -> "Hard"
        else -> "Medium"
    }

    val backgroundColor = when (selectedDifficulty) {
        "Easy" -> Color(0xFFA8E6CF)
        "Medium" -> Color(0xFFFFF59D)
        "Hard" -> Color(0xFFFF8A80)
        else -> Color.White
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(getGradientColors(offsetX))
            )
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "Choose Your Challenge!",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3F51B5)
        )

        Card(
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(180.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("🟢 Easy", fontWeight = FontWeight.SemiBold)
                    Text("🟡 Medium", fontWeight = FontWeight.SemiBold)
                    Text("🔴 Hard", fontWeight = FontWeight.SemiBold)
                }

                // Slider
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.6f)
                            .height(40.dp)
                            .background(getSliderColor(offsetX), shape = CircleShape)
                    )

                    // Thumb
                    Box(
                        modifier = Modifier
                            .offset { IntOffset(offsetX.roundToInt(), 0) }
                            .size(60.dp)
                            .clip(CircleShape)
                            .background(
                                when (selectedDifficulty) {
                                    "Easy" -> Color(0xFF4CAF50)
                                    "Medium" -> Color(0xFFFFC107)
                                    "Hard" -> Color(0xFFF44336)
                                    else -> Color.Blue
                                }
                            )
                            .draggable(
                                orientation = Orientation.Horizontal,
                                state = rememberDraggableState { delta ->
                                    viewModel.updateOffset(delta)
                                }
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("🎮", fontSize = 20.sp)
                    }
                }
            }
        }


        Text(
            text = "Current: $selectedDifficulty",
            fontSize = 18.sp,
            color = Color.DarkGray
        )
        // Animated Emoji that changes with difficulty
        Crossfade(
            targetState = selectedDifficulty,
            label = "DifficultyFaceTransition"
        ) { difficulty ->
            val emoji = when (difficulty) {
                "Easy" -> "🐣"
                "Medium" -> "😐"
                "Hard" -> "😈"
                else -> "🙂"
            }
            Text(
                text = emoji,
                fontSize = 60.sp,
                modifier = Modifier
                    .padding(top = 16.dp)
            )
        }


        // Buttons
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { onExit() },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB0BEC5)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("❌ Exit")
            }

            Button(
                onClick = {
                    viewModel.setDifficulty(selectedDifficulty)
                    onPlay()
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("▶️ Play")
            }
        }
    }

}

@Composable
fun getSliderColor(offsetX: Float): Color {
    return when {
        offsetX <= -80f -> Color(0xFF4CAF50) // Easy
        offsetX >= 80f -> Color(0xFFF44336) // Hard
        else -> {
            val progress = (offsetX + 80f) / 160f // Map -80 to 80 → 0f to 1f
            lerp(Color(0xFF4CAF50), Color(0xFFF44336), progress)
        }
    }
}
@Composable
fun getGradientColors(offsetX: Float): List<Color> {
    val easyColor = Color(0xFF4CAF50)    // Green
    val mediumColor = Color(0xFFFFC107)  // Yellow
    val hardColor = Color(0xFFF44336)    // Red

    val clampedOffset = offsetX.coerceIn(-120f, 120f)
    val progress = (clampedOffset + 120f) / 240f

    // Blend Green → Yellow → Red
    return if (progress < 0.5f) {
        // From Green to Yellow
        val innerProgress = progress / 0.5f
        listOf(lerp(easyColor, mediumColor, innerProgress), Color.White)
    } else {
        // From Yellow to Red
        val innerProgress = (progress - 0.5f) / 0.5f
        listOf(lerp(mediumColor, hardColor, innerProgress), Color.White)
    }
}



