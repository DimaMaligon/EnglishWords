package com.example.englishwords

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.englishwords.data.Alphabet
import com.example.englishwords.navigation.Screens
import com.example.englishwords.ui.theme.fontPlayfair

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LetterListScreen(navController: NavHostController) {
    val letters = remember {
        Alphabet.listLetters
    }
    Surface(color = MaterialTheme.colorScheme.primaryContainer) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.app_name), Modifier.padding(start = 50.dp),
                            fontFamily = fontPlayfair, fontWeight = FontWeight.Normal
                        )
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
                    )

                )
            },
            content = { padding ->
                Column(modifier = Modifier.padding(padding)) {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(4)
                    ) {
                        items(
                            letters.size,
                            key = { index ->
                                letters.get(index)
                            },
                            null,
                            contentType = {
                                Char
                            },
                            itemContent = {
                                LetterListItem(letter = letters.get(it), navController)
                            }
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = {
                                navController.navigate(route = Screens.RepeatWords.route)
                            },
                            Modifier
                                .width(250.dp)
                                .padding(top = 10.dp)
                        ) {
                            Text(stringResource(R.string.repeat_words), fontSize = 25.sp)
                        }
                    }
                }
            }
        )
    }
}

@Composable
fun LetterListItem(letter: String, navController: NavHostController) {
    val letterCard = letter

    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    )
    {
        Column(Modifier.padding(start = 22.dp)) {
            Text(
                text = letterCard,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .clickable {
                        navController.navigate(route = Screens.Letter.passLetter(letterCard))
                    }
                    .fillMaxSize()
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun LetterListScreenPreview() {
    LetterListScreen(navController = rememberNavController())
}