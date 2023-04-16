package com.example.englishwords

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.englishwords.data.Alphabet

@Composable
fun LetterListScreen(navController: NavHostController) {
    val letters = remember {
        Alphabet.listLetters
    }
    Scaffold(
        content = { padding ->
            LazyVerticalGrid(
                modifier = Modifier.padding(padding),
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
        }
    )
}

@Composable
fun LetterListItem(letter: String, navController: NavHostController) {
    val letterCard = letter

    Card(
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp,
        backgroundColor = Color.Blue,
        modifier = Modifier.padding(14.dp)
    )
    {
        Column(
            modifier = Modifier.clickable {
                navController.navigate(route = Screens.Letter.passLetter(letterCard))
            },
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = letterCard,
                fontSize = 35.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }

}

@Composable
@Preview(showBackground = true)
fun LetterListScreenPreview() {
    LetterListScreen(navController = rememberNavController())
}