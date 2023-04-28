package com.example.englishwords

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.navigation.NavHostController
import com.example.englishwords.data.Alphabet
import com.example.englishwords.navigation.Screens
import com.example.englishwords.ui.theme.fontPlayfair

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepeatWordsScreen(navController: NavHostController) {
    val letters = remember {
        Alphabet.listLetters
    }
    var openDialog by remember { mutableStateOf(false) }

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.app_name),
                    Modifier.padding(),
                    fontFamily = fontPlayfair,
                    fontWeight = FontWeight.Normal
                )
            },
            actions = {
                IconButton(onClick = {
                    openDialog = !openDialog
                }) {
                    Icon(Icons.Filled.Info, "infoIcon")
                }

            },
            navigationIcon = {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(Icons.Filled.ArrowBack, "backIcon")
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
            )
        )
    },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
            Row(Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                PopupWindowDialog(openDialog = openDialog)
            }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 250.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Угадал", fontSize = 25.sp)
                    Text(text = "Не угадал", Modifier.padding(start = 20.dp), fontSize = 25.sp)
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 55.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "0", fontSize = 25.sp)
                    Text(text = "0", Modifier.padding(start = 100.dp), fontSize = 25.sp)
                }
                Row(
                    Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Слово", fontSize = 25.sp)
                }
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Button(
                        onClick = {
                            navController.navigate(route = Screens.RepeatWords.route)
                        },
                        Modifier
                            .width(160.dp)
                            .padding(top = 10.dp)
                    ) {
                        Text(stringResource(R.string.repeat_words), fontSize = 20.sp)
                    }
                    Button(
                        onClick = {
                            navController.navigate(route = Screens.RepeatWords.route)
                        },
                        Modifier
                            .width(165.dp)
                            .padding(start = 10.dp, top = 10.dp)
                    ) {
                        Text(stringResource(R.string.repeat_words), fontSize = 20.sp)
                    }
                }
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Button(
                        onClick = {
                            navController.navigate(route = Screens.RepeatWords.route)
                        },
                        Modifier
                            .width(160.dp)
                            .padding(top = 10.dp)
                    ) {
                        Text(stringResource(R.string.repeat_words), fontSize = 20.sp)
                    }
                    Button(
                        onClick = {
                            navController.navigate(route = Screens.RepeatWords.route)
                        },
                        Modifier
                            .width(165.dp)
                            .padding(start = 10.dp, top = 10.dp)
                    ) {
                        Text(stringResource(R.string.repeat_words), fontSize = 20.sp)
                    }
                }
            }
        }
    )
}

@Composable
fun PopupWindowDialog(openDialog: Boolean){
    
    Box {
        val popupWidth = 300.dp
        val popupHeight = 200.dp

        if (openDialog) {
            Popup(
                properties = PopupProperties()
            ) {
                Box(
                    Modifier
                        .size(popupWidth, popupHeight)
                        .padding(top = 5.dp)
                        .background(
                            MaterialTheme.colorScheme.surfaceVariant,
                            RoundedCornerShape(10.dp)
                        )
                        .border(
                            2.dp,
                            color = MaterialTheme.colorScheme.secondary,
                            RoundedCornerShape(10.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Выберите один из вариантов перевода.\n" +
                                    "Счетчики указывают количество правильных и неправильных ответов",
                            modifier = Modifier.padding(vertical = 5.dp),
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}