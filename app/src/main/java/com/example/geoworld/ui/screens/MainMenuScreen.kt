package com.example.geoworld.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import android.app.Activity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.example.geoworld.R

@Composable
fun MainMenuScreen(onNavigate: (String) -> Unit) {
    val context = LocalContext.current
    val activity = context as? Activity
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(R.string.main_menu_title), fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onNavigate("region_selection") }) {
            Text(stringResource(R.string.start_game_button))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { onNavigate("stats") }) {
            Text(stringResource(R.string.stats_button))
        }
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            activity?.finish()
        }) {
            Text(stringResource(R.string.exit_game_button))
        }
    }
}