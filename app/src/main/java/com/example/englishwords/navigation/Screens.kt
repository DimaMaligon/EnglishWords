package com.example.englishwords.navigation

const val DETAIL_ARGUMENT_LETTER = "letter"

sealed class Screens(val route: String) {
object Letter: Screens("letter_screen/{$DETAIL_ARGUMENT_LETTER}")
object LetterList: Screens("letter_list_screen")
object RepeatWords: Screens("repeat_words_screen")
object Error: Screens("error_screen")

    fun passLetter(letter: String): String {
        return this.route.replace(oldValue = "{$DETAIL_ARGUMENT_LETTER}", newValue = letter)
    }
}