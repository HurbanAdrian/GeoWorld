package com.example.geoworld.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.geoworld.model.Country
import com.example.geoworld.model.GameMode
import com.example.geoworld.model.Region
import com.example.geoworld.viewmodel.QuizViewModel


@Composable
fun QuizScreen(region: Region, mode: GameMode, onNavigate: (String) -> Unit) {
    val viewModel: QuizViewModel = remember { QuizViewModel(region) }
    val question by viewModel.currentQuestion.collectAsState()

    var selectedAnswer by remember { mutableStateOf<Country?>(null) }
    var showResult by remember { mutableStateOf(false) }

    question?.let { q ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(WindowInsets.statusBars.asPaddingValues()) // odsun od výrezu/notchu
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = when (mode) {
                    GameMode.FLAGS -> "Ktorá vlajka patrí krajine:"
                    GameMode.MAPS -> "Ktorá mapa patrí krajine:"
                },
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(text = q.country.name, fontSize = 28.sp)

            Spacer(modifier = Modifier.height(24.dp))

            q.options.forEach { option ->
                val isCorrect = option == q.country
                val borderColor = when {
                    showResult && option == selectedAnswer && isCorrect -> Color.Green
                    showResult && option == selectedAnswer && !isCorrect -> Color.Red
                    showResult && isCorrect -> Color.Green
                    else -> Color.Transparent
                }

                val imageResId = when (mode) {
                    GameMode.FLAGS -> option.flagResId
                    GameMode.MAPS -> option.mapResId
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                        .height(100.dp)
                        .clickable(enabled = !showResult) {
                            selectedAnswer = option
                            showResult = true
                        }
                        .border(
                            BorderStroke(3.dp, borderColor),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Image(
                        painter = painterResource(id = imageResId),
                        contentDescription = option.name,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            if (showResult) {
                Button(
                    onClick = {
                        viewModel.generateQuestion()
                        selectedAnswer = null
                        showResult = false
                    }
                ) {
                    Text("Ďalšia otázka")
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = { onNavigate("main_menu") }) {
                Text("Ukončiť hru")
            }
        }
    }
}