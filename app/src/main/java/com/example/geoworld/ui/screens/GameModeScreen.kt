package com.example.geoworld.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.geoworld.R
import com.example.geoworld.model.GameMode
import com.example.geoworld.model.Region

/**
 * Obrazovka výberu herného módu pre zvolený región.
 *
 * Používateľ si tu vyberá medzi rôznymi hernými módmi (napr. Vlajky alebo Slepa mapa),
 * ktoré sú reprezentované enum triedou [GameMode]. Po výbere sa naviguje na obrazovku kvízu.
 *
 * @param regionName Názov regiónu vo forme reťazca (napr. "EUROPE"). Ak je null, použije sa predvolený región "EUROPE".
 * @param onNavigate Lambda, ktorá spracováva navigáciu medzi obrazovkami.
 */
@Composable
fun GameModeScreen(regionName: String?, onNavigate: (String) -> Unit) {
    // Bezpečné prevedenie reťazca na enum hodnotu. Ak je null, predvolená hodnota je "EUROPE" -> ta je isto dobre
    val region = Region.valueOf(regionName ?: "EUROPE")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.statusBars.asPaddingValues())
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Nadpis obrazovky
        Text(stringResource(R.string.choose_game_mode), fontSize = 24.sp)
        Spacer(modifier = Modifier.height(24.dp))

        // Pre každý dostupný herný mód vytvoriť jedno tlačidlo
        GameMode.entries.forEach { mode ->
            Button(
                onClick = {
                    // Navigácia na obrazovku kvízu s vybraným regiónom a módovým enumom
                    onNavigate("quiz/${region.name}/${mode.name}")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                shape = RoundedCornerShape(50)
            ) {
                // Použitie lokalizovaného názvu módu
                Text(text = stringResource(id = mode.labelResId))
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Button(
            // Tlačidlo na návrat späť na výber regiónu
            onClick = { onNavigate("region_selection") },
            shape = RoundedCornerShape(50)
        ) {
            Text(stringResource(R.string.back))
        }
    }
}