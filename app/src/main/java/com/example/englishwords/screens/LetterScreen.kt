package com.example.englishwords.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.englishwords.LocalLetterViewModel
import com.example.englishwords.LocalNavController
import com.example.englishwords.R
import com.example.englishwords.navigation.Screens
import com.example.englishwords.ui.theme.fontPlayfair

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LetterScreen(
    letter: String?
) {
    val navController = LocalNavController.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        Modifier.padding(),
                        fontFamily = fontPlayfair,
                        fontWeight = FontWeight.Normal
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
                ),
                actions = {
                    IconButton(onClick = {
                        navController.navigate(Screens.EnterWordsScreen.route)
                    }) {
                        Icon(
                            Icons.Filled.Add,
                            stringResource(id = R.string.title_icon_enter_words)
                        )
                    }

                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            stringResource(id = R.string.title_icon_back)
                        )
                    }
                }
            )
        },
        content = { padding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(100.dp)
            ) {
                TitleWords()
                Search()
                Words(letterFrom = letter)
            }

        },
        containerColor = MaterialTheme.colorScheme.background
    )
}

@Composable
fun TitleWords() {
    val letterViewModel = LocalLetterViewModel.current
    letterViewModel.apply {
        val letterScreen by letter.collectAsState()
        Column(modifier = Modifier.padding(bottom = 15.dp)) {
            val titleScreen = stringResource(R.string.title_screen_letter)
            Text(
                text = "$titleScreen $letterScreen",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun Words(letterFrom: String?) {
    val letterViewModel = LocalLetterViewModel.current
    letterViewModel.apply {
        val englishList by englishList.collectAsState()
        val searchWord by searchWord.collectAsState()
        val translateWord by translateWord.collectAsState()
        setLetter(letterFrom)
        Column() {
            if (searchWord.equals("")) {
                getEnglishList()
            } else {
                getEnglishTranslateWord(searchWord)
                val list = arrayListOf(translateWord)
                setEnglishList(list)
            }
            WordList(listWords = englishList)
        }
    }
}

@Composable
fun WordList(listWords: List<String>) {
    LazyColumn(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()

    ) {
        items(listWords) {
            Text(
                text = it,
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .shadow(15.dp),
                maxLines = 3
            )

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search() {
    val letterViewModel = LocalLetterViewModel.current
    letterViewModel.apply {
        val searchWord by searchWord.collectAsState()
        Column() {
            TextField(
                value = searchWord,
                onValueChange = {
                    setSearchWord(it)
                },
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "",
                        modifier = Modifier
                            .size(24.dp)
                    )
                },
                trailingIcon = {
                    if (searchWord != "") {
                        IconButton(
                            onClick = {
                                setSearchWord("")
                            }
                        ) {
                            Icon(
                                Icons.Default.Close,
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(15.dp)
                                    .size(24.dp)
                            )
                        }
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                singleLine = true,
                shape = MaterialTheme.shapes.medium
            )
        }
    }
}