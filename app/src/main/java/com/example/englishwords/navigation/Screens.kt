package com.example.englishwords.navigation

const val DETAIL_ARGUMENT_LETTER = "letter"
const val LETTER_ROUTE = "letter"
const val START_ROUTE = "start"
const val REPEAT_WORDS_ROUTE = "repeat_words"
const val ROOT_ROUTE = "root"
sealed class Screens(val route: String) {

object Start: Screens("start_screen")
object Letter: Screens("letter_screen/{$DETAIL_ARGUMENT_LETTER}")
object LetterList: Screens("letter_list_screen")
object RepeatWords: Screens("repeat_words_screen")
object Error: Screens("error_screen")
object EnterWordsScreen: Screens("enter_words_screen")

    fun passLetter(letter: String): String {
        return this.route.replace(oldValue = "{$DETAIL_ARGUMENT_LETTER}", newValue = letter)
    }
}