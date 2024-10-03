package com.example.rolldice.ui

import androidx.activity.OnBackPressedDispatcher
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.rolldice.ui.home.HomeScreen

fun NavGraphBuilder.AppNavGraph(
    navController: NavController, onBackPressedDispatcher: OnBackPressedDispatcher
) {
    navigation(
        route = "home",
        startDestination = "home_start_destination"
    ) {
        composable("home_start_destination") { HomeScreen(navController) }
    }
}