package com.example.englishwords

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.englishwords.db.MyDbManager

@Composable
fun SetUpNavGraph(
    navController: NavHostController, myDbManager: MyDbManager
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
            val letterFromList = it.arguments?.getString(DETAIL_ARGUMENT_LETTER).toString()
            Log.d("dddd letter", it.arguments?.getString(DETAIL_ARGUMENT_LETTER).toString())
            LetterScreen(navController, myDbManager, letterFromList)
        }

    }

}
