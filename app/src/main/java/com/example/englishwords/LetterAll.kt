package com.example.englishwords

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.englishwords.data.Alphabet

@Composable
fun LetterAllList (padding: PaddingValues, navigateToProfile: (String) -> Unit) {
    val letters = remember {
        Alphabet.listLetters
    }
    LazyVerticalGrid(
        modifier = Modifier.padding(padding),
        columns = GridCells.Fixed(4)

    ) {
        items(
            letters.size,
            key = {
                  index ->
                letters.get(index)
            },
            null,
            contentType = {
                          Char
            },
            itemContent = {
                LetterListItem(letter = letters.get(it), navigateToProfile)
            }
        )
    }
}