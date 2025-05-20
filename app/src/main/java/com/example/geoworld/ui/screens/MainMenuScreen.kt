package com.example.geoworld.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import android.app.Activity
import androidx.compose.ui.platform.LocalContext

@Composable
fun MainMenuScreen(onNavigate: (String) -> Unit) {
    val context = LocalContext.current
    val activity = context as? Activity
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Main Menu", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onNavigate("region_selection") }) {
            Text("Začať hru")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { onNavigate("stats") }) {
            Text("Štatistiky")
        }
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            activity?.finish()
        }) {
            Text("Ukončiť hru")
        }
    }
}