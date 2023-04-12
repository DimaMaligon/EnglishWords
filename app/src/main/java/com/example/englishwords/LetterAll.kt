package com.example.englishwords

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.englishwords.data.Alphabet

@Composable
fun LetterAllList(padding: PaddingValues, navigateToLetter: (String) -> Unit) {
    val letters = remember {
        Alphabet.listLetters
    }
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
                LetterListItem(letter = letters.get(it), navigateToLetter)
            }
        )
    }
}