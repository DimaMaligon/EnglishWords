package com.example.englishwords

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.englishwords.databinding.LetterItemBinding

class LetterAdapter : RecyclerView.Adapter<LetterAdapter.LetterHolder>() {
    private val list = ('A').rangeTo('Z').toList()

    class LetterHolder(item: View) : RecyclerView.ViewHolder(item){
        val binding = LetterItemBinding.bind(item)
        var buttonLetterText = binding.buttonLetter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.letter_item, parent, false)
        return LetterHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: LetterHolder, position: Int) {
        holder.buttonLetterText.text = list[position].toString()

        holder.buttonLetterText.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, LetterActivity::class.java)
            intent.putExtra("letter", holder.buttonLetterText.text.toString())
            context.startActivity(intent)
        }
    }
}