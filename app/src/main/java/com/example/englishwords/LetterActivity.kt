package com.example.englishwords

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.englishwords.databinding.ActivityLetterBinding
import com.example.englishwords.db.MyDbManager

class LetterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLetterBinding
    private val myDbManager = MyDbManager(this)
    private lateinit var letter: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLetterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        letter = intent.extras?.getString("letter").toString()
        binding.textTitleLetter.text = "Слова на букву $letter"
        onClickSave(letter)
    }

    override fun onDestroy() {
        myDbManager.closeDb()
        super.onDestroy()
    }

    private fun readWordsLetter(letter: String) {
        val list = myDbManager.readWordsTable(letter)
        for (item in list) {
            binding.textdb.append(item)
            binding.textdb.append("\n")
        }
    }

    private fun onClickSave(letter: String) {
        binding.button.setOnClickListener {
            myDbManager.openDb()
            myDbManager.insertToLetterTable(
                letter
            )
            myDbManager.insertToWordsTable(
                letter,
                binding.editTextTextPersonName.text.toString(),
                binding.editTextTextPersonName2.text.toString()
            )
            readWordsLetter(letter)
        }
    }
}