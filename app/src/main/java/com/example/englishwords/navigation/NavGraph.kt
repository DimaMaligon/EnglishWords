package com.example.englishwords.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.englishwords.ErrorScreen
import com.example.englishwords.LetterListScreen
import com.example.englishwords.LetterScreen
import com.example.englishwords.RepeatWordsScreen
import com.example.englishwords.viewmodel.LetterViewModel
import com.example.englishwords.viewmodel.RepeatWordsViewModel

@Composable
fun NavGraph(
    navController: NavHostController, listViewModel: ArrayList<ViewModel>
) {
    NavHost(
        navController = navController,
        startDestination = Screens.LetterList.route
    )
    {
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
                else -> LetterScreen(navController, letterFromList, listViewModel.get(0) as LetterViewModel)
            }
        }

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

    }

}
