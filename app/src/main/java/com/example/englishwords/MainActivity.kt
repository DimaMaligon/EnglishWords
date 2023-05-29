package com.example.englishwords

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.englishwords.db.MyDbManager
import com.example.englishwords.navigation.NavGraph
import com.example.englishwords.ui.theme.EnglishWordsTheme
import com.example.englishwords.viewmodel.LetterViewModel
import com.example.englishwords.viewmodel.RepeatWordsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


val LocalLetterViewModel = compositionLocalOf<LetterViewModel> { error("No List Views") }
val LocalRepeatViewModel = compositionLocalOf<RepeatWordsViewModel> { error("No List Views") }
val LocalNavController = compositionLocalOf<NavHostController> { error("No NavController") }

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var myDbManager: MyDbManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myDbManager.openDb()
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

    override fun onDestroy() {
        myDbManager.closeDb()
        super.onDestroy()
    }
}