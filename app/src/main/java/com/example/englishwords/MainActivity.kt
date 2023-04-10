package com.example.englishwords

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp{
                startActivity(ProfileActivity.newIntent(this, it))
            }
        }
    }
}

@Composable
fun MyApp(navigationToProfile: (String) -> Unit) {
    Scaffold(
        content = { padding ->
            LetterAllList(padding, navigateToProfile = navigationToProfile)
        }
    )
}
