package com.example.englishwords

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.englishwords.db.MyDbManager

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    private val myDbManager = MyDbManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            myDbManager.openDb()
            navController = rememberNavController()
            NavGraph(navController = navController, myDbManager)
        }
    }

    override fun onDestroy() {
        myDbManager.closeDb()
        super.onDestroy()
    }
}

