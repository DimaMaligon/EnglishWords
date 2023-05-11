package com.example.englishwords.navigation

import androidx.lifecycle.ViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.englishwords.screens.EnterWordsScreen
import com.example.englishwords.screens.ErrorScreen
import com.example.englishwords.screens.LetterListScreen
import com.example.englishwords.screens.LetterScreen
import com.example.englishwords.viewmodel.LetterViewModel

fun NavGraphBuilder.navGraphLetter(navController: NavHostController, listViewModel: ArrayList<ViewModel>){
    val viewModelLetter = listViewModel[0] as LetterViewModel

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
            LetterListScreen(navController)
        }

        composable(
            route = Screens.Letter.route
        ) {
            val letterFromList = it.arguments?.getString(DETAIL_ARGUMENT_LETTER) ?: ""
            when(letterFromList){
                ""-> ErrorScreen(navController)
                else -> LetterScreen(navController, letterFromList, viewModelLetter)
            }
        }

        composable(
            route = Screens.EnterWordsScreen.route
        ) {
            EnterWordsScreen(navController, viewModelLetter)
        }
    }

}