package com.example.englishwords.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.englishwords.screens.ErrorScreen
import com.example.englishwords.screens.RepeatWordsScreen
import com.example.englishwords.screens.StartScreen
import com.example.englishwords.viewmodel.RepeatWordsViewModel

@Composable
fun NavGraph(
    navController: NavHostController, listViewModel: ArrayList<ViewModel>
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Start.route
    )
    {
        navGraphLetter(navController, listViewModel)
        composable(
            route = Screens.Error.route
        ) {
            ErrorScreen(navController)
        }
        composable(
            route = Screens.RepeatWords.route
        ) {
            RepeatWordsScreen(navController, listViewModel.get(1) as RepeatWordsViewModel)
        }
        composable(
            route = Screens.Start.route
        ) {
            StartScreen(navController)
        }
    }
}