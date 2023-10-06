package com.englishwords

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.englishwords.navigation.NavGraph
import com.englishwords.ui.theme.EnglishWordsTheme
import com.englishwords.viewmodel.LetterViewModel
import com.englishwords.viewmodel.RepeatWordsViewModel
import dagger.hilt.android.AndroidEntryPoint

val LocalLetterViewModel = compositionLocalOf<LetterViewModel> { error("No List Views") }
val LocalRepeatViewModel = compositionLocalOf<RepeatWordsViewModel> { error("No List Views") }
val LocalNavController = compositionLocalOf<NavHostController> { error("No NavController") }

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val letterVM: LetterViewModel by viewModels()
        val repeatVM: RepeatWordsViewModel by viewModels()

        setContent {
            val navController = rememberNavController()
            CompositionLocalProvider(
                LocalLetterViewModel provides letterVM,
                LocalRepeatViewModel provides repeatVM,
                LocalNavController provides navController
            ) {
                EnglishWordsTheme {
                    NavGraph()
                }
            }
        }
    }
}