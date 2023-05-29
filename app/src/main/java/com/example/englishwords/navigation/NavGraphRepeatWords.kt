package com.example.englishwords.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.englishwords.screens.RepeatWordsScreen

fun NavGraphBuilder.navGraphRepeatWords(){
    navigation(
        startDestination = Screens.RepeatWords.route,
        route = REPEAT_WORDS_ROUTE
    ) {
        composable(
            route = Screens.RepeatWords.route
        ) {
            RepeatWordsScreen()
        }
    }
}