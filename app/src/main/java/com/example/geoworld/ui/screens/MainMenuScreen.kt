package com.example.geoworld.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.geoworld.R

/**
 * Hlavná menu obrazovka aplikácie GeoWorld.
 *
 * Obsahuje tri hlavné akcie pre používateľa:
 * - Začať hru (naviguje na výber regiónu)
 * - Zobraziť štatistiky (naviguje na štatistickú obrazovku)
 * - Ukončiť hru (zatvorí aktivitu)
 *
 * @param onNavigate Lambda funkcia, ktorá spracováva navigáciu medzi obrazovkami cez route reťazce.
 */
@Composable
fun MainMenuScreen(onNavigate: (String) -> Unit) {
    val context = LocalContext.current
    val activity = context as? Activity
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.globe),
            contentDescription = stringResource(R.string.globe_description),
            modifier = Modifier
                .size(180.dp)
                .padding(bottom = 24.dp)
        )

        // Nadpis menu
        Text(stringResource(R.string.main_menu_title), fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        // Tlačidlo pre štart novej hry
        Button(onClick = { onNavigate("region_selection") }) {
            Text(stringResource(R.string.start_game_button))
        }
        Spacer(modifier = Modifier.height(8.dp))
        // Tlačidlo pre zobrazenie štatistík hráča
        Button(onClick = { onNavigate("stats") }) {
            Text(stringResource(R.string.stats_button))
        }
        Spacer(modifier = Modifier.height(8.dp))

        // Tlačidlo na ukončenie aplikácie
        Button(onClick = {
            activity?.finish()                              // Bezpečne ukončí aktivitu, ak existuje
        }) {
            Text(stringResource(R.string.exit_game_button))
        }
    }
}