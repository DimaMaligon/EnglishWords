package com.example.englishwords

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
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
            SetUpNavGraph(navController = navController, myDbManager)
        }
    }

    override fun onDestroy() {
        myDbManager.closeDb()
        super.onDestroy()
    }
}

