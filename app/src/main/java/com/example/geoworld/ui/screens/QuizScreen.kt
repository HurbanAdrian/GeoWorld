package com.example.geoworld.ui.screens

import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.geoworld.R
import com.example.geoworld.data.database.AppDatabase
import com.example.geoworld.data.database.entity.PlayerStatsEntity
import com.example.geoworld.data.repository.PlayerStatsRepository
import com.example.geoworld.model.GameMode
import com.example.geoworld.model.Region
import com.example.geoworld.service.StatsService
import com.example.geoworld.viewmodel.QuizViewModel
import com.example.geoworld.viewmodel.QuizViewModelFactory
import com.example.geoworld.viewmodel.StatsViewModel
import com.example.geoworld.viewmodel.StatsViewModelFactory
import kotlinx.coroutines.delay


@Composable
fun QuizScreen(region: Region, mode: GameMode, onNavigate: (String) -> Unit) {
    val viewModel: QuizViewModel = viewModel(
        factory = QuizViewModelFactory(region)
    )
    val question by viewModel.currentQuestion.collectAsState()

    var selectedAnswer by viewModel.selectedAnswer
    var showResult by viewModel.showResult

    val context = LocalContext.current
    LaunchedEffect(viewModel.gameOver.value) {              // ako side effect, pri zmene gameOver spusti raz tento blok, ide ako coroutina
        if (viewModel.gameOver.value) {
            val intent = Intent(context, StatsService::class.java)
            context.startService(intent)
            viewModel.resetGame()
        }
    }

    val statsViewModel: StatsViewModel = viewModel(
        factory = StatsViewModelFactory(
            PlayerStatsRepository(AppDatabase.getInstance(context).playerStatsDao())
        )
    )

    question?.let { q ->
        LaunchedEffect(showResult) {
            if (showResult && selectedAnswer != null) {
                val isCorrect = selectedAnswer == question?.country
                delay(300)          // mierne oneskorenie na aktualizovanie stavu
                val stat = PlayerStatsEntity(
                    score = viewModel.score.intValue,
                    correctAnswers = if (isCorrect) 1 else 0,
                    date = System.currentTimeMillis(),
                    region = region.name,
                    streak = viewModel.streak.intValue,
                    livesLeft = viewModel.lives.intValue
                )
                statsViewModel.insertStat(stat)
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(WindowInsets.statusBars.asPaddingValues())         // odsun od výrezu/notchu
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("${stringResource(R.string.lives_label)} ${viewModel.lives.intValue}")
                Text("${stringResource(R.string.score_label)} ${viewModel.score.intValue}")
            }

            Text(
                text = when (mode) {
                    GameMode.FLAGS -> stringResource(R.string.question_flag_prompt)
                    GameMode.MAPS -> stringResource(R.string.question_map_prompt)
                },
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(text = stringResource(id = q.country.nameResId), fontSize = 28.sp)

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
                            viewModel.answerSelected(option)
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
                        contentDescription = stringResource(id = option.nameResId),
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
                    Text(stringResource(R.string.next_question_button))
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = { onNavigate("main_menu") }) {
                Text(stringResource(R.string.exit_game_button))
            }
        }
    }
}