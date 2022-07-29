package com.ieltsjuice.dictionary

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ieltsjuice.R
import com.ieltsjuice.WithoutBottomNavigationBarActivity
import com.ieltsjuice.databinding.FragmentDictionaryBinding
import com.ieltsjuice.model.Dictionary
import com.ieltsjuice.model.DictionaryRepository
import com.ieltsjuice.model.local.DictionaryDatabase
import com.ieltsjuice.model.local.DictionaryLocalDataClass
import com.ieltsjuice.util.ApiServiceSingleton
import com.ieltsjuice.util.MainViewModelFactory
import com.ieltsjuice.util.PAGE_NAME_KEY
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import java.util.stream.Collectors


class FragmentDictionary : Fragment(), DictionaryAdapter.PressedBtn,
    DictionaryAdapter.UsPronunciation, DictionaryAdapter.UkPronunciation {
    lateinit var tts: TextToSpeech
    lateinit var binding: FragmentDictionaryBinding
    lateinit var dictionaryViewModel: DictionaryViewModel
    private val compositeDisposable = CompositeDisposable()
    lateinit var dictionaryAdapter: DictionaryAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDictionaryBinding.inflate(layoutInflater, container, false)
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

        binding.edtTextDictionary.addTextChangedListener {
            if (it!!.isNotEmpty()) {
                getSearchWord(it.toString())
            } else {
                binding.dictionaryRecyclerView.visibility = View.GONE
            }
        }

        binding.favButton.setOnClickListener {
            val intent =
                Intent(this.requireActivity(), WithoutBottomNavigationBarActivity::class.java)
            intent.putExtra(PAGE_NAME_KEY, "favoriteWords")
            startActivity(intent)
            activity?.finish()
        }

        //Fab icon custom style
        var scrollingDown = false
        binding.dictionaryRecyclerView.addOnScrollListener(object :
            RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if (scrollingDown
                    && dy >= 1
                ) {
                    scrollingDown = !scrollingDown
                    binding.favButton.startAnimation(
                        AnimationUtils.loadAnimation(
                            activity?.applicationContext,
                            R.anim.fab_close
                        )
                    )
                } else if (!scrollingDown
                    && dy < 1
                ) {
                    scrollingDown = !scrollingDown
                    binding.favButton.startAnimation(
                        AnimationUtils.loadAnimation(
                            activity?.applicationContext,
                            R.anim.fab_open
                        )
                    )
                }
            }
        })

    }

    private fun getSearchWord(word: String) {
        with(dictionaryViewModel) {
            getWordMeaning(word)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<Dictionary> {
                    override fun onSubscribe(d: Disposable) {
                        compositeDisposable.add(d)
                    }

                    override fun onSuccess(t: Dictionary) {
                        binding.serverError500.visibility = View.INVISIBLE
                        binding.txtError.visibility = View.INVISIBLE
                        binding.dictionaryRecyclerView.visibility = View.VISIBLE
                        setDataToRecycler(t)
                    }

                    override fun onError(e: Throwable) {
                        binding.serverError500.visibility = View.VISIBLE
                        binding.txtError.visibility = View.VISIBLE
                        binding.serverError500.playAnimation()
                        binding.dictionaryRecyclerView.visibility = View.GONE
                    }

                })
        }
    }

    private fun setDataToRecycler(data: Dictionary) {
        val myData = ArrayList(data)
        dictionaryAdapter = DictionaryAdapter(myData, this, this, this)
        binding.dictionaryRecyclerView.adapter = dictionaryAdapter
        binding.dictionaryRecyclerView.layoutManager =
            LinearLayoutManager(this.requireActivity(), RecyclerView.VERTICAL, false)
    }

    override fun onItemClickListener(itemClicked: Dictionary.DictionaryItem) {
        Toast.makeText(
            this.requireActivity(),
            itemClicked.word + " added to Favorite",
            Toast.LENGTH_SHORT
        ).show()

        dictionaryViewModel.getAllFavData().observe(this.requireActivity()) {
            if (!it.toString()
                    .contains(itemClicked.meanings?.get(0)?.definitions?.get(0)?.definition.toString())
            ) {
                addItemToDatabase(itemClicked)
            }
        }
    }

    private fun addItemToDatabase(itemClicked: Dictionary.DictionaryItem) {
        var noOfDefinition = 0
        var no = 1
        var listOfDefinitions: ArrayList<String?> = arrayListOf()
        for (i in 1..10) {
            try {
                listOfDefinitions.add(
                    "$no) " + itemClicked.meanings?.get(0)?.definitions?.get(
                        noOfDefinition
                    )?.definition + "\n"
                )
                no += 1
                noOfDefinition += 1
            } catch (e: Exception) {
                //catch Error
            }
        }
        val definition =
            listOfDefinitions.stream()
                .collect(Collectors.joining(""))  // remove   "["     &   "]"   &   ","   from the list

        lifecycleScope.launch(Dispatchers.IO) {
            dictionaryViewModel.insertWordToFav(
                DictionaryLocalDataClass(
                    word = itemClicked.word.toString(),
                    definition = definition,
                    phonetics = itemClicked.phonetic.toString(),
                    partOfSpeech = itemClicked.meanings?.get(0)?.partOfSpeech.toString()
                )
            )
        }
    }

    override fun onUsSpeakerClickListener(itemClicked: Dictionary.DictionaryItem) {
        val toSpeak = itemClicked.word.toString()
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

    override fun onUkSpeakerClickListener(itemClicked: Dictionary.DictionaryItem) {
        val toSpeak = itemClicked.word.toString()
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