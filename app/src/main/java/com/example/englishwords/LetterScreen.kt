package com.example.englishwords

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.res.stringResource
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
                Words(letterViewModel = letterViewModel, letterFrom = letter)
            }

        }
    )
}

@Composable
fun Words(letterViewModel: LetterViewModel, letterFrom: String?) {
    letterViewModel.apply {
        val letterScreen by letter.collectAsState()
        val englishWord by englishWord.collectAsState()
        val englishTranscription by englishTranscription.collectAsState()
        val englishList by englishList.collectAsState()

        setLetter(letterFrom)
        Column() {
            Column() {
                val titleScreen = stringResource(R.string.title_screen_letter)
                Text(
                    text = "$titleScreen $letterScreen",
                    fontSize = 25.sp,
                    fontStyle = FontStyle.Normal
                )
            }
            WordList(listWords = englishList)
            Column {
                TextField(
                    value = englishWord,
                    onValueChange = { setEnglishWord(it) })

                TextField(
                    value = englishTranscription,
                    onValueChange = { setEnglishTranscription(it) },
                    Modifier.padding(top = 10.dp))

                Button(
                    onClick = {
                        setTap(true)
                        getEnglishList()
                        setTap(false)

                    },
                    Modifier
                        .width(250.dp)
                        .padding(top = 10.dp)
                ) {
                    Text(stringResource(R.string.save_word), fontSize = 25.sp)
                }
            }
        }
    }
}

@Composable 
fun WordList(listWords: List<String>){
    LazyColumn(
        modifier = Modifier
            .padding(8.dp)
            .height(120.dp)

    ) {
        items(listWords) {
            Text(
                text = it,
                modifier = Modifier.padding(vertical = 10.dp)
            )

        }
    }
}


