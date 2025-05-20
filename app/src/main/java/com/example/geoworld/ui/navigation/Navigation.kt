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

@Composable
fun GeoWorldNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "main_menu"
    ) {
        composable("main_menu") {
            MainMenuScreen(onNavigate = { navController.navigate(it) })
        }

        composable("region_selection") {
            RegionSelectionScreen(onNavigate = { navController.navigate(it) })
        }

        composable("game_mode/{region}") { backStackEntry ->
            val region = backStackEntry.arguments?.getString("region")
            GameModeScreen(regionName = region, onNavigate = { navController.navigate(it) })
        }

        composable("quiz/{region}/{mode}") { backStackEntry ->
            val region = Region.valueOf(backStackEntry.arguments?.getString("region") ?: "EUROPE")
            val mode = GameMode.valueOf(backStackEntry.arguments?.getString("mode") ?: "FLAGS")
            QuizScreen(region = region, mode = mode, onNavigate = { navController.navigate(it) })
        }

        composable("stats") {
            StatsScreen(onNavigate = { navController.navigate(it) })
        }
    }
}