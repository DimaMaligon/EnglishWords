package com.example.englishwords

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.englishwords.ui.theme.fontPlayfair
import com.example.englishwords.viewmodel.LetterViewModel

@OptIn(ExperimentalMaterial3Api::class)
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
                    Text(
                        text = stringResource(id = R.string.app_name),
                        Modifier.padding(start = 10.dp),
                        fontFamily = fontPlayfair,
                        fontWeight = FontWeight.Normal
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
                ),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(Icons.Filled.ArrowBack, stringResource(id = R.string.title_icon_back))
                    }
                }
            )
        },
        content = { padding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(100.dp)
            ) {
                Words(letterViewModel = letterViewModel, letterFrom = letter)
            }

        },
        containerColor = MaterialTheme.colorScheme.background
    )
}

@OptIn(ExperimentalMaterial3Api::class)
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

            getEnglishList()
            WordList(listWords = englishList)
            Column {
                TextField(
                    value = englishWord,
                    onValueChange = { setEnglishWord(it) })

                TextField(
                    value = englishTranscription,
                    onValueChange = { setEnglishTranscription(it) },
                    Modifier.padding(top = 10.dp)
                )

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
fun WordList(listWords: List<String>) {
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


