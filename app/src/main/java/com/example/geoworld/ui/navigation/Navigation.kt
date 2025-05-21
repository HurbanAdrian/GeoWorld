package com.example.geoworld.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.geoworld.model.GameMode
import com.example.geoworld.model.Region
import com.example.geoworld.ui.screens.GameModeScreen
import com.example.geoworld.ui.screens.MainMenuScreen
import com.example.geoworld.ui.screens.QuizScreen
import com.example.geoworld.ui.screens.RegionSelectionScreen
import com.example.geoworld.ui.screens.StatsScreen

/**
 * Navigačný hostiteľ pre aplikáciu GeoWorld.
 * Obsahuje všetky navigačné cesty (routes) definované pomocou Jetpack Navigation Compose.
 *
 * @param navController NavController, ktorý riadi navigáciu medzi obrazovkami.
 */
@Composable
fun GeoWorldNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "main_menu"      // routy nedavam do resources
    ) {
        // Hlavné menu
        composable("main_menu") {
            MainMenuScreen(onNavigate = { navController.navigate(it) })
        }

        // Výber regiónu
        composable("region_selection") {
            RegionSelectionScreen(onNavigate = { navController.navigate(it) })
        }

        // Výber herného módu pre zvolený región (parametrizovaný route)
        composable("game_mode/{region}") { backStackEntry ->                    // navigacna route sablona
            val region = backStackEntry.arguments?.getString("region")
            GameModeScreen(regionName = region, onNavigate = { navController.navigate(it) })
        }

        // Kvízová obrazovka, ktorá prijíma región a herný mód (získané z argumentov routy)
        composable("quiz/{region}/{mode}") { backStackEntry ->
            val region = Region.valueOf(backStackEntry.arguments?.getString("region") ?: "EUROPE")      // na enumy
            val mode = GameMode.valueOf(backStackEntry.arguments?.getString("mode") ?: "FLAGS")
            QuizScreen(region = region, mode = mode, onNavigate = { navController.navigate(it) })
        }

        // Obrazovka so štatistikami
        composable("stats") {
            StatsScreen(onNavigate = { navController.navigate(it) })
        }
    }
}