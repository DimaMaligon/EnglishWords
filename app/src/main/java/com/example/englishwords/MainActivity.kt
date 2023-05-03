package com.example.englishwords

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.englishwords.db.MyDbManager
import com.example.englishwords.navigation.NavGraph
import com.example.englishwords.ui.theme.EnglishWordsTheme
import com.example.englishwords.viewmodel.LetterViewModel
import com.example.englishwords.viewmodel.RepeatWordsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    lateinit var listViewModel: ArrayList<ViewModel>

    @Inject
    lateinit var myDbManager: MyDbManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myDbManager.openDb()
        val letterVM: LetterViewModel by viewModels()
        val repeatVM: RepeatWordsViewModel by viewModels()
        listViewModel = arrayListOf(letterVM, repeatVM)
        setContent {
            EnglishWordsTheme {
                navController = rememberNavController()
                NavGraph(navController = navController, listViewModel = listViewModel)
            }
        }
    }

    override fun onDestroy() {
        myDbManager.closeDb()
        super.onDestroy()
    }
}

