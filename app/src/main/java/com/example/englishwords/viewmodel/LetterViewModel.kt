package com.example.englishwords.viewmodel

import androidx.lifecycle.ViewModel
import com.example.englishwords.db.MyDbManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LetterViewModel @Inject constructor(val myDbManager: MyDbManager) : ViewModel() {

    private val letterMutable = MutableStateFlow("")
    val letter: StateFlow<String> = letterMutable
    private val englishWordMutable = MutableStateFlow("")
    val englishWord: StateFlow<String> = englishWordMutable
    private val englishTranscriptionMutable = MutableStateFlow("")
    val englishTranscription: StateFlow<String> = englishTranscriptionMutable
    private val englishListMutable: MutableStateFlow<MutableList<String>> =
        MutableStateFlow(mutableListOf())
    val englishList: StateFlow<List<String>> = englishListMutable
    private val tapMutable = MutableStateFlow(false)
    val tap: StateFlow<Boolean> = tapMutable

    fun setLetter(letter: String) {
        letterMutable.value = letter
    }

    fun setEnglishWord(word: String) {
        englishWordMutable.value = word
    }

    fun setEnglishTranscription(word: String) {
        englishTranscriptionMutable.value = word
    }

    fun getEnglishList() {
        englishListMutable.value = myDbManager.readWordsTable(letter.value)
    }

    fun setTap(tap: Boolean) {
        when (tap) {
            true -> {
                letter.let {
                    myDbManager.insertToWordsTable(
                        it.value,
                        englishWordMutable.value,
                        englishTranscriptionMutable.value
                    )
                }
            }

            else -> {}
        }
    }
}