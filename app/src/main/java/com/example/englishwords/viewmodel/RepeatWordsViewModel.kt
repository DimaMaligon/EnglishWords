package com.example.englishwords.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.englishwords.room.DbManager
import com.example.englishwords.room.Word
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepeatWordsViewModel @Inject constructor(var dbManager: DbManager) : ViewModel() {
    private val daoData = dbManager.getDao()

    private val guessCountMutable = MutableStateFlow(0)
    val guessCount: StateFlow<Int> = guessCountMutable
    private val noGuessCountMutable = MutableStateFlow(0)
    val noGuessCount: StateFlow<Int> = noGuessCountMutable
    private val englishWordsListMutable: MutableStateFlow<MutableList<Word>> =
        MutableStateFlow(mutableListOf())
    val englishWordsList: StateFlow<MutableList<Word>> = englishWordsListMutable
    private val shuffleWordsListMutable: MutableStateFlow<MutableList<Word>> =
        MutableStateFlow(mutableListOf())
    val shuffleWordsList: MutableStateFlow<MutableList<Word>> = shuffleWordsListMutable
    private val showDialogMutable = MutableStateFlow(false)
    val showDialog: StateFlow<Boolean> = showDialogMutable

    fun getEnglishWordsMap() {
//        if (dbManager.checkWordsTable()) {
//            onOpenDialogClicked()
//        } else {
        viewModelScope.launch {
            englishWordsListMutable.value = daoData.readRandomWords()
        }
    }

    fun updateTranslateList() {
        val listTranscription = englishWordsListMutable.value
        shuffleWordsListMutable.value = listTranscription.apply { shuffle() }
    }


    fun guessWord(word: Word): Boolean {
        shuffleWordsListMutable.value
            .let {
                it.forEach { element ->
                    if (element.wordEnglish == word.wordEnglish) {
                        return true
                    }
                }
            }
        return false
    }

    fun increaseCounts(guess: Boolean) {
        when (guess) {
            true -> guessCountMutable.value++
            false -> noGuessCountMutable.value++
        }
    }

    fun onOpenDialogClicked() {
        showDialogMutable.value = true
    }

    fun onDialogConfirm() {
        showDialogMutable.value = false
    }

    fun onDialogDismiss() {
        showDialogMutable.value = false
    }
}