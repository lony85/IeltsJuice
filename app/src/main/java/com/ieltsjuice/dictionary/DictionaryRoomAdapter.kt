package com.ieltsjuice.dictionary

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ieltsjuice.databinding.TemplateDictionaryContentBinding
import com.ieltsjuice.model.local.DictionaryLocalDataClass

class DictionaryRoomAdapter(
    private val dictionary: List<DictionaryLocalDataClass>,
    private val pressed: DictionaryRoomAdapter.PressedBtn,
    private val US_pronunciation: DictionaryRoomAdapter.UsPronunciation,
    private val UK_pronunciation: DictionaryRoomAdapter.UkPronunciation
) : RecyclerView.Adapter<DictionaryRoomAdapter.Holder>() {

    inner class Holder(private val binding: TemplateDictionaryContentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bindData(category: DictionaryLocalDataClass) {

            binding.txtTitleDictionary.text = category.word
            binding.txtPartOfSpeechDictionary.text = category.partOfSpeech
            binding.txtPhoneticDictionary.text = category.phonetics
            binding.txtDescDictionary.text = category.definition

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
        fun onItemClickListener(itemClicked: DictionaryLocalDataClass)
    }
    interface UsPronunciation {
        fun onUsSpeakerClickListener(itemClicked: DictionaryLocalDataClass)
    }
    interface UkPronunciation {
        fun onUkSpeakerClickListener(itemClicked: DictionaryLocalDataClass)
    }
}