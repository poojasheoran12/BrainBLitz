package com.example.brainblitz.ui



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.brainblitz.R
import com.example.brainblitz.model.GameViewModel

@Composable
fun ResultScreen(
    viewModel: GameViewModel,
    score: Int,
    total: Int,
    onPlayAgain: () -> Unit,
    onExit: () -> Unit
) {



    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF6F8FF)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "🎉 Quiz Completed!",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3F51B5)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Your Score",
                fontSize = 20.sp,
                color = Color.Gray
            )

            Text(
                text = "$score /50",
                fontSize = 40.sp,
                fontWeight = FontWeight.ExtraBold,
                color = if (score >= total / 2) Color(0xFF4CAF50) else Color(0xFFF44336)
            )

            Spacer(modifier = Modifier.height(16.dp))


//             Image(
//                 painter = painterResource(R.drawable.trophy),
//                 contentDescription = "Result Image",
//                 modifier = Modifier.size(150.dp)
//             )

            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Button(
                    onClick = onPlayAgain,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F51B5))
                ) {
                    Text(text = "Play Again", color = Color.White)
                }

                Button(
                    onClick = onExit,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
                ) {
                    Text(text = "Exit")
                }
            }
        }
    }
}
