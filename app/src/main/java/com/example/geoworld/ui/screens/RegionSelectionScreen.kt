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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.geoworld.R
import com.example.geoworld.model.Region

/**
 * Obrazovka pre výber regiónu, z ktorého budú otázky v kvíze.
 *
 * Umožňuje používateľovi zvoliť geografický región (napr. Európa, Ázia, Afrika, ...),
 * po čom sa naviguje na obrazovku výberu herného módu.
 *
 * @param onNavigate Funkcia pre navigáciu na ďalšiu obrazovku podľa zvoleného regiónu.
 */
@Composable
fun RegionSelectionScreen(onNavigate: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.statusBars.asPaddingValues())     // status baru
            .padding(horizontal = 16.dp), // horizontálne vycentrovanie
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Nadpis obrazovky
        Text(stringResource(R.string.select_region_title), fontSize = 24.sp)
        Spacer(modifier = Modifier.height(24.dp))

        // Tlačidlá pre jednotlivé regióny
        Region.entries.forEach { region ->
            Button(
                onClick = { onNavigate("game_mode/${region.name}") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                shape = RoundedCornerShape(50)      // zaoblený vzhľad tlačidla
            ) {
                Text(text = stringResource(id = region.labelResId))
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Tlačidlo späť do hlavného menu
        Button(
            onClick = { onNavigate("main_menu") },
            shape = RoundedCornerShape(50)
        ) {
            Text(stringResource(R.string.back))
        }
    }
}