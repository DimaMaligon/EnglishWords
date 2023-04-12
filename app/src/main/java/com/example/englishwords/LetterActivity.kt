package com.example.englishwords

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.englishwords.db.MyDbManager

class LetterActivity : AppCompatActivity() {
    private val myDbManager = MyDbManager(this)
    private val letter: String? by lazy {
        intent.getSerializableExtra(letterId, String::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myDbManager.openDb()
        setContent {
            ScreenLetter(myDbManager = myDbManager, letter = letter)
        }
    }

    override fun onDestroy() {
        myDbManager.closeDb()
        super.onDestroy()
    }

    companion object {
        private val letterId = "letter"
        fun newIntent(context: Context, letter: String) =
            Intent(context, LetterActivity::class.java).apply {
                putExtra(letterId, letter)
            }
    }
}

@Composable
fun ScreenLetter(myDbManager: MyDbManager, letter: String?) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Кнопка Назад")
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White,
                elevation = 10.dp
            )
        },
        content = { padding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(100.dp)
            ) {
                ReadAndShowWords(myDbManager = myDbManager, letter = letter)
            }

        }
    )
}

@Composable
fun ReadAndShowWords(myDbManager: MyDbManager, letter: String?) {
    val englishWord = remember { mutableStateOf("") }
    val englishTranscription = remember { mutableStateOf("") }
    var englishList: MutableList<String>

    Column() {
        Column() {
            Text(
                text = "Слова на букву $letter",
                fontSize = 25.sp,
                fontStyle = FontStyle.Normal
            )
        }
        Column(
            modifier = Modifier
                .padding(50.dp)
                .height(70.dp)
                .verticalScroll(rememberScrollState())

        ) {
            englishList = myDbManager.readWordsTable(letter)
            for (item in englishList) {
                Text(
                    text = "$item\n"
                )
            }
        }
        Column {
            TextField(value = englishWord.value, onValueChange = { englishWord.value = it })
            TextField(
                value = englishTranscription.value,
                onValueChange = { englishTranscription.value = it })

            Button(onClick = {
                letter?.let { it1 ->
                    myDbManager.insertToLetterTable(
                        it1
                    )
                }
                letter?.let { it1 ->
                    myDbManager.insertToWordsTable(
                        it1,
                        englishWord.value,
                        englishTranscription.value
                    )
                }
                englishList = myDbManager.readWordsTable(letter)
            }) {
                Text("Save", fontSize = 25.sp)
            }
        }
    }
}