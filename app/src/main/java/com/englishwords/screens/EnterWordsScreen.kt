package com.englishwords.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.englishwords.LocalLetterViewModel
import com.englishwords.LocalNavController
import com.englishwords.R
import com.englishwords.ui.theme.fontPlayfair
import com.englishwords.viewmodel.LetterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterWordsScreen() {
    val letterViewModel = LocalLetterViewModel.current
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
                WordFields(letterViewModel = letterViewModel)
            }

        },
        containerColor = MaterialTheme.colorScheme.background
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WordFields(letterViewModel: LetterViewModel) {
    letterViewModel.apply {
        val englishWord by englishWord.collectAsState()
        val englishTranscription by englishTranscription.collectAsState()

        Column() {
            Column {
                Text(
                    text = stringResource(id = R.string.english_word),
                    Modifier.padding(start = 60.dp),
                    style = MaterialTheme.typography.titleMedium
                )

                TextField(
                    value = englishWord,
                    onValueChange = { setEnglishWord(it) },
                    shape = MaterialTheme.shapes.medium,
                    colors = TextFieldDefaults.textFieldColors(
                        disabledTextColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    maxLines = 3
                )

                Text(
                    text = stringResource(id = R.string.translate_word),
                    Modifier.padding(start = 50.dp, top = 10.dp),
                    style = MaterialTheme.typography.titleMedium
                )

                TextField(
                    value = englishTranscription,
                    onValueChange = { setEnglishTranscription(it) },
                    shape = MaterialTheme.shapes.medium,
                    colors = TextFieldDefaults.textFieldColors(
                        disabledTextColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    maxLines = 3
                )

                Button(
                    onClick = {
                        setTap(true)
                        setTap(false)
                    },
                    Modifier
                        .width(250.dp)
                        .padding(top = 10.dp),
                ) {
                    Text(
                        stringResource(R.string.save_word),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}