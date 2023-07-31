package com.example.englishwords.viewmodel

import androidx.lifecycle.ViewModel
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
class RepeatWordsViewModel @Inject constructor(dbManager: DbManager) : ViewModel() {
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
    private val showProgressMutable = MutableStateFlow(true)
    val showProgress: StateFlow<Boolean> = showProgressMutable
    private val keyLaunchRepeatMutable = MutableStateFlow(false)
    val keyLaunchRepeat: StateFlow<Boolean> = keyLaunchRepeatMutable

    suspend fun getEnglishWordsMap() =
        withContext(Dispatchers.IO) {
            val emptyDataBase = daoData.checkIsEmpty()
            if (!emptyDataBase) {
                val countWords = daoData.checkWordsTable()
                if (countWords > 3) {
                  launch {
                      englishWordsListMutable.value = daoData.readRandomWords()
                      onCloseProgress()
                  }
                }
                else {
                    onCloseProgress()
                    onOpenDialogClicked()
                }
            } else {
                onCloseProgress()
                onOpenDialogClicked()
            }
        }

    suspend fun createShuffleTranslateList() =
        withContext(Dispatchers.IO) {
            onShowProgress()
            val listTranscription = englishWordsListMutable.value
            shuffleWordsListMutable.value = listTranscription.apply { shuffle() }
            onCloseProgress()
        }


    fun guessWord(word: Word): Boolean {
        englishWordsListMutable.value
            .let {
                    if (it.first().wordEnglish == word.wordEnglish) {
                        return true
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

    fun onCloseProgress() {
        showProgressMutable.value = false
    }

    fun onShowProgress() {
        showProgressMutable.value = true
    }

    fun setLaunchKeyRepeat(key: Boolean) {
        keyLaunchRepeatMutable.value = key
    }
}