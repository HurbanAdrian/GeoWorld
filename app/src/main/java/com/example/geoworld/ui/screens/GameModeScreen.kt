package com.example.geoworld.ui.screens

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.geoworld.model.GameMode
import com.example.geoworld.model.Region

@Composable
fun GameModeScreen(regionName: String?, onNavigate: (String) -> Unit) {
    val region = Region.valueOf(regionName ?: "EUROPE")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.statusBars.asPaddingValues())
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Vyber herný mód", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(24.dp))

        GameMode.entries.forEach { mode ->
            Button(
                onClick = {
                    onNavigate("quiz/${region.name}/${mode.name}")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                shape = RoundedCornerShape(50)
            ) {
                Text(mode.label)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { onNavigate("region_selection") },
            shape = RoundedCornerShape(50)
        ) {
            Text("Späť")
        }
    }
}