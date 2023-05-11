package com.example.englishwords.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.englishwords.screens.ErrorScreen

@Composable
fun NavGraph(
    navController: NavHostController, listViewModel: ArrayList<ViewModel>
) {
    NavHost(
        navController = navController,
        startDestination = START_ROUTE,
        route = ROOT_ROUTE
    )
    {
        navGraphStart(navController)
        navGraphLetter(navController, listViewModel)
        navGraphRepeatWords(navController,listViewModel)
        composable(
            route = Screens.Error.route
        ) {
            ErrorScreen(navController)
        }
    }
}