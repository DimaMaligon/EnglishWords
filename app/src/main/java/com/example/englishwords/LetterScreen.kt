package com.example.englishwords

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.englishwords.viewmodel.LetterViewModel

@Composable
fun LetterScreen(
    navController: NavHostController,
    letter: String?,
    letterViewModel: LetterViewModel
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
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
                ReadAndShowWords(letterViewModel = letterViewModel, letterFrom = letter)
            }

        }
    )
}

@Composable
fun ReadAndShowWords(letterViewModel: LetterViewModel, letterFrom: String?) {
    letterViewModel.apply {
        val letterScreen by letter.collectAsState()
        val englishWord by englishWord.collectAsState()
        val englishTranscription by englishTranscription.collectAsState()
        val englishList by englishList.collectAsState()

        setLetter(letterFrom!!)
        Column() {
            Column() {
                Text(
                    text = "Слова на букву $letterScreen",
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
                for (item in englishList) {
                    Text(
                        text = "$item\n"
                    )
                }
            }
            Column {
                TextField(value = englishWord, onValueChange = { setEnglishWord(it) })
                TextField(
                    value = englishTranscription,
                    onValueChange = { setEnglishTranscription(it) })

                Button(onClick = {
                    setTap(true)
                    getEnglishList()
                    setTap(false)

                }) {
                    Text("Save", fontSize = 25.sp)
                }
            }
        }
    }
}

