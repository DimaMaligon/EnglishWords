package com.englishwords.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.englishwords.LocalNavController
import com.englishwords.LocalRepeatViewModel
import com.englishwords.R
import com.englishwords.navigation.LETTER_ROUTE
import com.englishwords.navigation.Screens
import com.englishwords.ui.theme.fontPlayfair

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepeatWordsScreen() {
    val navController = LocalNavController.current
    var openDialog by remember { mutableStateOf(false) }

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = stringResource(id = R.string.app_name),
                Modifier.padding(),
                fontFamily = fontPlayfair,
                fontWeight = FontWeight.Normal
            )
        }, actions = {
            IconButton(onClick = {
                openDialog = !openDialog
            }) {
                Icon(Icons.Filled.Info, stringResource(id = R.string.title_icon_info))
            }

        }, navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(Icons.Filled.ArrowBack, stringResource(id = R.string.title_icon_info))
            }
        }, colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
        )
        )
    }, content = { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            Row(
                Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
            ) {
                PopupWindowDialog(
                    openDialog = openDialog,
                    stringResource(id = R.string.text_ifo_about_repeat_words)
                )
            }
            RepeatWordsWithAlert()
        }
    })
}

@Composable
fun CountsGuessWords() {
    val repeatWordsViewModel = LocalRepeatViewModel.current
    repeatWordsViewModel.apply {
        val countGuess by guessCount.collectAsState()
        val noGuessCount by noGuessCount.collectAsState()
        val showProgress by showProgress.collectAsState()

        if (showProgress) {
            SimpleAlertCircularProgressIndicator(show = true) {
            }
        } else {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 250.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.guess_word),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = stringResource(id = R.string.no_guess_word),
                    Modifier.padding(start = 20.dp),
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 55.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = countGuess.toString(),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = noGuessCount.toString(),
                    Modifier.padding(start = 100.dp),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}


@Composable
fun ButtonsEnglishWords() {
    val repeatWordsViewModel = LocalRepeatViewModel.current
    repeatWordsViewModel.apply {
        val listRandomWords by englishWordsList.collectAsState()
        val listShuffleWords by shuffleWordsList.collectAsState()

        Row(
            Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = listRandomWords.first().wordEnglish,
                style = MaterialTheme.typography.titleMedium
            )
        }

        LazyVerticalGrid(columns = GridCells.Adaptive(200.dp), content = {
            items(listShuffleWords.size) { index ->
                Button(
                    onClick = {
                        guessWord(listShuffleWords[index]).run { increaseCounts(this) }
                        val v = !keyLaunchRepeat.value
                        setLaunchKeyRepeat(v)
                    },
                    Modifier
                        .width(160.dp)
                        .padding(top = 10.dp)
                ) {
                    Text(
                        listShuffleWords[index].translate, style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        })
    }
}

@SuppressLint("ResourceType")
@Composable
fun RepeatAlertDialog(showDialog: Boolean) {
    val navController = LocalNavController.current
    SimpleAlertDialog(show = showDialog,
        title = stringResource(id = R.string.alert_title),
        text = stringResource(id = R.string.alert_text),
        ok = stringResource(id = R.string.alert_ok),
        onConfirm = {
            navController.navigate(route = LETTER_ROUTE) {
                popUpTo(route = Screens.RepeatWords.route) {
                    inclusive = true
                }
            }
        })
}

@SuppressLint(
    "CoroutineCreationDuringComposition", "ProduceStateDoesNotAssignValue",
    "StateFlowValueCalledInComposition"
)
@Composable
fun RepeatWordsWithAlert() {
    val repeatWordsViewModel = LocalRepeatViewModel.current
    repeatWordsViewModel.apply {
        val showProgress by showProgress.collectAsState()
        val showDialog by showDialog.collectAsState()
        val keyLaunch by keyLaunchRepeat.collectAsState()

        LaunchedEffect(key1 = keyLaunch) {
            getEnglishWordsMap()
            createShuffleTranslateList()
        }

        if (showProgress) {
            SimpleAlertCircularProgressIndicator(show = true) {
            }
        } else {
            RepeatAlertDialog(showDialog)
            if (!showDialog) {
                CountsGuessWords()
                ButtonsEnglishWords()
            }
        }
    }
}