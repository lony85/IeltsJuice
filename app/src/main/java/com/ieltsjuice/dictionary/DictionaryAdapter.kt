package com.ieltsjuice.dictionary

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ieltsjuice.databinding.TemplateDictionaryContentBinding
import com.ieltsjuice.model.Dictionary
import com.ieltsjuice.model.Youtube
import java.lang.Exception

class DictionaryAdapter(private val dictionary: ArrayList<Dictionary.DictionaryItem>, private val pressed: PressedBtn)
    : RecyclerView.Adapter<DictionaryAdapter.Holder>() {

    inner class Holder(private val binding: TemplateDictionaryContentBinding) : RecyclerView.ViewHolder(binding.root) {

       @SuppressLint("SetTextI18n")
       fun bindData(category: Dictionary.DictionaryItem) {


//           var a = category.meanings?.get(0)?.definitions?.get(0)?.definition
//           val a = category.meanings?.get(0)?.definitions?.get(1)?.definition
//           Log.i("adapter",a.toString())
//           binding.txtDescDictionary.text = a
//           binding.txtTitleDictionary.text = category.word
           binding.txtTitleDictionary.text = category.word
           binding.txtPartOfSpeechDictionary.text = category.meanings?.get(0)?.partOfSpeech
            binding.txtPhoneticDictionary.text = category.phonetic

           var noOfDefinition = 0
           var listOfDefinitions: ArrayList<String?> = arrayListOf()
           for (i in 1 .. 10){
               try {
                   listOfDefinitions.add(category.meanings?.get(0)?.definitions?.get(noOfDefinition)?.definition)
                noOfDefinition += 1
               }catch (e:Exception){
                   //catch Error
               }
           }
            binding.txtDescDictionary.text = listOfDefinitions.toString().substring( 1, listOfDefinitions.toString().length - 1 )


//           category.meanings?.get(0)?.definitions?.get(noOfDefinition)?.definition

//           Log.i("adapter",noOfDefinition.toString())
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