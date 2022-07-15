package com.ieltsjuice.dictionary

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.ieltsjuice.databinding.FragmentDictionaryBinding
import com.ieltsjuice.model.Dictionary
import com.ieltsjuice.model.DictionaryRepository
import com.ieltsjuice.model.Youtube
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class FragmentDictionary :Fragment() ,DictionaryAdapter.PressedBtn {
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
        dictionaryViewModel = DictionaryViewModel(DictionaryRepository())

        binding.edtTextDictionary.addTextChangedListener {
            if (it!!.isNotEmpty()) {
                getSearchWord(it.toString())
            } else {
                binding.dictionaryRecyclerView.visibility = View.GONE
            }
        }
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
                        binding.dictionaryRecyclerView.visibility = View.VISIBLE


                        setDataToRecycler(t)
                        Log.i("test", t.toString())
                    }

                    override fun onError(e: Throwable) {
                        binding.dictionaryRecyclerView.visibility = View.GONE
                        Log.i("test_error", e.toString())
                    }

                })
        }
    }

    private fun setDataToRecycler(data: Dictionary) {
        val myData = ArrayList(data)
        dictionaryAdapter = DictionaryAdapter(myData, this)
        binding.dictionaryRecyclerView.adapter = dictionaryAdapter
        binding.dictionaryRecyclerView.layoutManager =
            LinearLayoutManager(this.requireActivity(), RecyclerView.VERTICAL, false)
    }

    override fun onItemClickListener(itemClicked: Youtube.Item.Snippet) {
        TODO("Not yet implemented")
    }
}