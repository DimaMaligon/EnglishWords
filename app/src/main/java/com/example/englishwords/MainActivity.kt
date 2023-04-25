package com.example.englishwords

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.englishwords.db.MyDbManager
import com.example.englishwords.navigation.NavGraph
import com.example.englishwords.viewmodel.LetterViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController

    @Inject
    lateinit var myDbManager: MyDbManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myDbManager.openDb()
        val vm: LetterViewModel by viewModels()
        setContent {
            navController = rememberNavController()
            NavGraph(navController = navController, letterViewModel = vm)
        }
    }

    override fun onDestroy() {
        myDbManager.closeDb()
        super.onDestroy()
    }
}

