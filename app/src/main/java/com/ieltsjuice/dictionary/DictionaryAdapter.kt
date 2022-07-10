package com.ieltsjuice.dictionary

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ieltsjuice.databinding.TemplateDictionaryContentBinding
import com.ieltsjuice.model.Dictionary
import com.ieltsjuice.model.Youtube

class DictionaryAdapter(private val dictionary: ArrayList<Dictionary.DictionaryItem.Meaning.Definition>, private val pressed: PressedBtn) :
    RecyclerView.Adapter<DictionaryAdapter.Holder>() {


    inner class Holder(private val binding: TemplateDictionaryContentBinding) : RecyclerView.ViewHolder(binding.root) {

       @SuppressLint("SetTextI18n")
       fun bindData(category: Dictionary.DictionaryItem.Meaning.Definition) {


//            binding.txtTitleDictionary.text = category.word
            binding.txtDescDictionary.text = category.definition


            itemView.setOnClickListener {
//                pressed.onItemClickListener(category)
            }
            
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = TemplateDictionaryContentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindData(dictionary[position])
    }

    override fun getItemCount(): Int {
        return dictionary.size
    }

    // 1.create interface in adapter
    // 2. get an object of interface in args of adapter
    // 3. fill (or call) object of interface with your date
    // 4. implementation in MainActivity
    interface PressedBtn{
        fun onItemClickListener(itemClicked:Youtube.Item.Snippet)

    }
}