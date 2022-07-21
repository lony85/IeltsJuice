package com.ieltsjuice.dictionary

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.ColorFilter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColor
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.ieltsjuice.R
import com.ieltsjuice.databinding.TemplateDictionaryContentBinding
import com.ieltsjuice.model.Dictionary
import com.ieltsjuice.model.DictionaryRepository
import com.ieltsjuice.model.local.DictionaryDao
import com.ieltsjuice.model.local.DictionaryDatabase
import com.ieltsjuice.util.ApiServiceSingleton
import com.ieltsjuice.util.MainViewModelFactory
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList

class DictionaryAdapter(
    private val dictionary: ArrayList<Dictionary.DictionaryItem>,
    private val pressed: PressedBtn,
    private val US_pronunciation: UsPronunciation,
    private val UK_pronunciation: UkPronunciation
) : RecyclerView.Adapter<DictionaryAdapter.Holder>() {
    inner class Holder(private val binding: TemplateDictionaryContentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bindData(category: Dictionary.DictionaryItem) {

            binding.txtTitleDictionary.text = category.word
            binding.txtPartOfSpeechDictionary.text = category.meanings?.get(0)?.partOfSpeech
            binding.txtPhoneticDictionary.text = category.phonetic

            var noOfDefinition = 0
            var no = 1
            var listOfDefinitions: ArrayList<String?> = arrayListOf()
            for (i in 1..10) {
                try {
                    listOfDefinitions.add(
                        "$no) " + category.meanings?.get(0)?.definitions?.get(
                            noOfDefinition
                        )?.definition + "\n"
                    )
                    no += 1
                    noOfDefinition += 1
                } catch (e: Exception) {
                    //catch Error
                }
            }
            binding.txtDescDictionary.text =
                listOfDefinitions.stream()
                    .collect(Collectors.joining(""))  // remove   "["     &   "]"   &   ","   from the list


            binding.favBtn.setOnClickListener {
                pressed.onItemClickListener(category)

            }
            binding.USPronunciation.setOnClickListener {
                US_pronunciation.onUsSpeakerClickListener(category)
            }
            binding.UKPronunciation.setOnClickListener {
                UK_pronunciation.onUkSpeakerClickListener(category)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = TemplateDictionaryContentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
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
    interface PressedBtn {
        fun onItemClickListener(itemClicked: Dictionary.DictionaryItem)
    }
    interface UsPronunciation {
        fun onUsSpeakerClickListener(itemClicked: Dictionary.DictionaryItem)
    }
    interface UkPronunciation {
        fun onUkSpeakerClickListener(itemClicked: Dictionary.DictionaryItem)
    }
 }
