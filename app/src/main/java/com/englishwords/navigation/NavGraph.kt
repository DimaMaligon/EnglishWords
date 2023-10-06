package com.englishwords.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.englishwords.LocalNavController
import com.englishwords.screens.ErrorScreen

@Composable
fun NavGraph() {
    val navController = LocalNavController.current
    NavHost(
        navController = navController,
        startDestination = START_ROUTE,
        route = ROOT_ROUTE
    )
    {
        navGraphStart()
        navGraphLetter()
        navGraphRepeatWords()
        composable(
            route = Screens.Error.route
        ) {
            ErrorScreen()
        }
    }
}