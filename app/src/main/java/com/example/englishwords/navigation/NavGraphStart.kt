package com.example.englishwords.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.englishwords.screens.StartScreen

fun NavGraphBuilder.navGraphStart(){
    navigation(
        startDestination = Screens.Start.route,
        route = START_ROUTE
    ) {
        composable(
            route = Screens.Start.route
        ) {
            StartScreen()
        }
    }
}