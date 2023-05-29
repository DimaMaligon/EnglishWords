package com.example.englishwords.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.englishwords.screens.EnterWordsScreen
import com.example.englishwords.screens.ErrorScreen
import com.example.englishwords.screens.LetterListScreen
import com.example.englishwords.screens.LetterScreen

fun NavGraphBuilder.navGraphLetter(){

    navigation(
        startDestination = Screens.LetterList.route,
        route = LETTER_ROUTE
    ){
        composable(
            route = Screens.LetterList.route,
            arguments = listOf(
                navArgument(DETAIL_ARGUMENT_LETTER){
                    type = NavType.StringType
                })
        ) {
            LetterListScreen()
        }

        composable(
            route = Screens.Letter.route
        ) {
            val letterFromList = it.arguments?.getString(DETAIL_ARGUMENT_LETTER) ?: ""
            when(letterFromList){
                ""-> ErrorScreen()
                else -> LetterScreen(letterFromList)
            }
        }

        composable(
            route = Screens.EnterWordsScreen.route
        ) {
            EnterWordsScreen()
        }
    }

}