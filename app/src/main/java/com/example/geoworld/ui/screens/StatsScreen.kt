package com.example.geoworld.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.geoworld.data.database.AppDatabase
import com.example.geoworld.data.repository.PlayerStatsRepository
import com.example.geoworld.viewmodel.StatsViewModel
import com.example.geoworld.viewmodel.StatsViewModelFactory

@Composable
fun StatsScreen(onNavigate: (String) -> Unit) {
    val context = LocalContext.current
    val db = AppDatabase.getInstance(context)
    val repository = PlayerStatsRepository(db.playerStatsDao())
    val viewModel: StatsViewModel = viewModel(factory = StatsViewModelFactory(repository))
    val stats by viewModel.stats.collectAsState()

    val topScore = stats.maxOfOrNull { it.score } ?: 0
    val favoriteRegion = stats
        .groupingBy { it.region }
        .eachCount()
        .maxByOrNull { it.value }
        ?.key ?: "—"
    val topStreak = stats.maxOfOrNull { it.streak } ?: 0

    LaunchedEffect(Unit) {
        viewModel.loadStats()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(WindowInsets.statusBars.asPaddingValues())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Štatistiky hráča", fontSize = 24.sp)

        Text("📈 Top skóre: $topScore")
        Spacer(modifier = Modifier.height(4.dp))
        Text("🌍 Najčastejší región: $favoriteRegion")
        Spacer(modifier = Modifier.height(4.dp))
        Text("🔥 Najvyšší streak: $topStreak")
        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider(thickness = 1.dp)
        Spacer(modifier = Modifier.height(16.dp))
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { onNavigate("main_menu") }) {
            Text("Späť na menu")
        }

        Button(onClick = { viewModel.clearStats() }) {
            Text("Vymazať štatistiky")
        }

        Spacer(modifier = Modifier.height(24.dp))
        if (stats.isEmpty()) {
            Text("Zatiaľ žiadne výsledky")
        } else {
            stats.forEach {
                Text("Skóre: ${it.score}, Správne odp.: ${it.correctAnswers}, Dátum: ${formatDate(it.date)}")
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

    }
}

fun formatDate(timestamp: Long): String {
    val sdf = java.text.SimpleDateFormat("dd.MM.yyyy HH:mm", java.util.Locale.getDefault())
    return sdf.format(java.util.Date(timestamp))
}