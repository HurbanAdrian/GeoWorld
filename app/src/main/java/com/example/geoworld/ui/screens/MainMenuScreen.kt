package com.example.geoworld.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.geoworld.viewmodel.MainViewModel
import androidx.compose.ui.res.painterResource

@Composable
fun MainMenuScreen(viewModel: MainViewModel = viewModel()) {
    val countries = viewModel.countries

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("GeoWorld", fontSize = 28.sp)
        Spacer(modifier = Modifier.height(24.dp))
        Image(
            painter = painterResource(id = countries[0].flagResId),
            contentDescription = countries[0].name,
            modifier = Modifier.size(150.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Ukážka vlajky: ${countries[0].name}")
    }
}