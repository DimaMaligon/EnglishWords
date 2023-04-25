package com.example.englishwords.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.englishwords.LetterListScreen
import com.example.englishwords.LetterScreen
import com.example.englishwords.viewmodel.LetterViewModel

@Composable
fun NavGraph(
    navController: NavHostController, letterViewModel: LetterViewModel
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
            LetterScreen(navController, letterFromList, letterViewModel)
        }

    }

}
