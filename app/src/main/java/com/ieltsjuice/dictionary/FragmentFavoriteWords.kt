package com.ieltsjuice.dictionary

import android.os.Build
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ieltsjuice.databinding.FragmentFavoriteWordsBinding
import com.ieltsjuice.model.DictionaryRepository
import com.ieltsjuice.model.local.DictionaryDatabase
import com.ieltsjuice.model.local.DictionaryLocalDataClass
import com.ieltsjuice.util.ApiServiceSingleton
import com.ieltsjuice.util.MainViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class FragmentFavoriteWords : Fragment(), DictionaryRoomAdapter.PressedBtn,
    DictionaryRoomAdapter.UsPronunciation, DictionaryRoomAdapter.UkPronunciation {
    lateinit var dictionaryRoomAdapter: DictionaryRoomAdapter
    lateinit var binding: FragmentFavoriteWordsBinding
    lateinit var dictionaryViewModel: DictionaryViewModel
    lateinit var tts: TextToSpeech
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteWordsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        dictionaryViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(
                DictionaryRepository(
                    ApiServiceSingleton.dictionaryApiService!!,
                    DictionaryDatabase.getDatabase(this.requireActivity()).dictionaryDao
                )
            )
        ).get(DictionaryViewModel::class.java)

        dictionaryViewModel.getAllFavData().observe(this.requireActivity()) {
            refreshRecyclerData(it)
        }


    }

    private fun refreshRecyclerData(data: List<DictionaryLocalDataClass>) {
        dictionaryRoomAdapter = DictionaryRoomAdapter(data, this, this, this)
        binding.dictionaryRecyclerView.adapter = dictionaryRoomAdapter
        binding.dictionaryRecyclerView.layoutManager =
        LinearLayoutManager(this.requireActivity(), RecyclerView.VERTICAL, false)
    }

    override fun onItemClickListener(itemClicked: DictionaryLocalDataClass) {
        dictionaryViewModel.getAllFavData().observe(this.requireActivity()) {
            if (it.toString().contains(itemClicked.definition)) {
                lifecycleScope.launch(Dispatchers.IO) {
                    dictionaryViewModel.deleteWordFromFav(itemClicked.definition)
                }
            }
        }

    }

    override fun onUsSpeakerClickListener(itemClicked: DictionaryLocalDataClass) {
        val toSpeak = itemClicked.word
        tts = TextToSpeech(this.requireActivity(), TextToSpeech.OnInitListener { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts.language = Locale.US
                tts.setPitch(0.9f)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    tts.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null, null)
                } else {
                    tts.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null)
                }
            }
        })
    }

    override fun onUkSpeakerClickListener(itemClicked: DictionaryLocalDataClass) {
        val toSpeak = itemClicked.word
        tts = TextToSpeech(this.requireActivity(), TextToSpeech.OnInitListener { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts.language = Locale.UK
                tts.setPitch(0.9f)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    tts.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null, null)
                } else {
                    tts.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null)
                }
            }
        })
    }
}