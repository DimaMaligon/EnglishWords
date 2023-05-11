package com.example.englishwords.navigation

import androidx.lifecycle.ViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.englishwords.screens.RepeatWordsScreen
import com.example.englishwords.viewmodel.RepeatWordsViewModel

fun NavGraphBuilder.navGraphRepeatWords(navController: NavHostController, listViewModel: ArrayList<ViewModel>){
    navigation(
        startDestination = Screens.RepeatWords.route,
        route = REPEAT_WORDS_ROUTE
    ) {
        composable(
            route = Screens.RepeatWords.route
        ) {
            RepeatWordsScreen(navController, listViewModel[1] as RepeatWordsViewModel)
        }
    }
}