package com.example.englishwords.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.englishwords.room.DbManager
import com.example.englishwords.room.Word
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LetterViewModel @Inject constructor(dbManager: DbManager) : ViewModel() {
    private val daoData = dbManager.getDao()

    private val letterMutable = MutableStateFlow("")
    val letter: StateFlow<String> = letterMutable
    private val englishWordMutable = MutableStateFlow("")
    val englishWord: StateFlow<String> = englishWordMutable
    private val englishTranscriptionMutable = MutableStateFlow("")
    val englishTranscription: StateFlow<String> = englishTranscriptionMutable
    private val englishListMutable: MutableStateFlow<MutableList<Word>> =
        MutableStateFlow(mutableListOf())
    val englishList: StateFlow<List<Word>> = englishListMutable
    private val tapMutable = MutableStateFlow(false)
    val tap: StateFlow<Boolean> = tapMutable
    private val translateWordMutable = MutableStateFlow(Word("", "", ""))
    val translateWord: StateFlow<Word> = translateWordMutable
    private val searchWordMutable = MutableStateFlow("")
    val searchWord: StateFlow<String> = searchWordMutable

    fun setLetter(letter: String?) {
        letterMutable.value = letter.toString()
    }

    fun setEnglishWord(word: String) {
        englishWordMutable.value = word
    }

    fun setEnglishTranscription(word: String) {
        englishTranscriptionMutable.value = word
    }

    fun setSearchWord(word: String) {
        searchWordMutable.value = word
    }

    fun getEnglishList() {
        viewModelScope.launch {
            englishListMutable.value = withContext(Dispatchers.IO) {
                daoData.readWordsLetter(letter.value)
            }
        }
    }

    fun setEnglishList(list: List<Word>) {
        englishListMutable.value = list.toMutableList()
    }

    fun getEnglishTranslateWord(word: String) {
        viewModelScope.launch {
            var word = daoData.searchWord(word)
                translateWordMutable.value = word
        }
    }

    fun setTap(tap: Boolean) {
        when (tap) {
            true -> {
                letter.let {
                    viewModelScope.launch {
                        daoData.insertToWords(
                            Word(
                                it.value,
                                englishWordMutable.value,
                                englishTranscriptionMutable.value
                            )
                        )
                    }
                }
            }
            else -> {}
        }
    }
}