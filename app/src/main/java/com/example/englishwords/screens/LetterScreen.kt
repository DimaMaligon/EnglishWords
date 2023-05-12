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
import androidx.navigation.NavHostController
import com.example.englishwords.R
import com.example.englishwords.navigation.Screens
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
                    TitleWords(letterViewModel = letterViewModel)
                    Search()
                    Words(letterViewModel = letterViewModel, letterFrom = letter)
                }

            },
            containerColor = MaterialTheme.colorScheme.background
        )
}

@Composable
fun TitleWords(letterViewModel: LetterViewModel) {
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
}@Composable
fun Words(letterViewModel: LetterViewModel, letterFrom: String?) {
    letterViewModel.apply {
        val englishList by englishList.collectAsState()
        setLetter(letterFrom)
        Column() {
            getEnglishList()
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
    Column() {
        TextField(
            value = "",
            onValueChange = { value ->
                value
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
                IconButton(
                    onClick = {
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


