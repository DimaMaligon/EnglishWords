package com.example.englishwords

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp{
                startActivity(LetterActivity.newIntent(this, it))
            }
        }
    }
}

@Composable
fun MyApp(navigationToLetter: (String) -> Unit) {
    Scaffold(
        content = { padding ->
            LetterAllList(padding, navigateToLetter = navigationToLetter)
        }
    )
}

@Composable
@Preview(showBackground = true)
fun MyAppPreview(){
    MyApp{}
}
