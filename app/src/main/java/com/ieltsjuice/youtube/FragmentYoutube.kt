package com.ieltsjuice.youtube

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.internetconnection.NetworkChecker
import com.google.android.material.snackbar.Snackbar
import com.google.android.youtube.player.YouTubeStandalonePlayer
import com.ieltsjuice.R
import com.ieltsjuice.databinding.FragmentYoutubeBinding
import com.ieltsjuice.model.Youtube
import com.ieltsjuice.model.Youtube.Item.Snippet
import com.ieltsjuice.model.YoutubeRepository
import com.ieltsjuice.util.youTubeApiKey
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class FragmentYoutube : Fragment(), YoutubeAdapter.PressedBtn {
    lateinit var binding: FragmentYoutubeBinding
    private lateinit var youtubeViewModel: YoutubeViewModel
    private val compositeDisposable = CompositeDisposable()
    private lateinit var youtubeAdapter: YoutubeAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentYoutubeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        youtubeViewModel = YoutubeViewModel(YoutubeRepository())

        if (NetworkChecker(this.requireActivity()).isInternetConnected) {
            overviewInit()
            firstInit()
        } else {
            snackBar()
        }



        binding.overviewModuleBtn.setOnClickListener {
            if (NetworkChecker(this.requireActivity()).isInternetConnected) {
                overviewInit()
                firstInit()
            }else {
                snackBar()
            }
        }
        binding.listeningModuleBtn.setOnClickListener {
            if (NetworkChecker(this.requireActivity()).isInternetConnected) {
                listeningInit()
            }else {
                snackBar()
            }
            binding.listeningModuleBtn.isSelected = true
            binding.listeningModuleBtn.isChecked = true
        }
        binding.readingModuleBtn.setOnClickListener {
            if (NetworkChecker(this.requireActivity()).isInternetConnected) {
                readingInit()
            }else {
                snackBar()
            }
            binding.readingModuleBtn.isSelected = true
            binding.readingModuleBtn.isChecked = true
        }
        binding.speakingModuleBtn.setOnClickListener {
            if (NetworkChecker(this.requireActivity()).isInternetConnected) {
                speakingInit()
            }else {
                snackBar()
            }
            binding.speakingModuleBtn.isSelected = true
            binding.speakingModuleBtn.isChecked = true

        }
        binding.writingModuleBtn.setOnClickListener {
            if (NetworkChecker(this.requireActivity()).isInternetConnected) {
                writingInit()
            }else {
                snackBar()
            }
            binding.writingModuleBtn.isSelected = true
            binding.writingModuleBtn.isChecked = true

        }
    }

    private fun firstInit() {
        binding.overviewModuleBtn.isSelected = true
        binding.overviewModuleBtn.isChecked = true
    }

    private fun overviewInit() {
        with(youtubeViewModel) {
            getOverviewPlayList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<Youtube> {

                    override fun onSubscribe(d: Disposable) {
                        compositeDisposable.add(d)
                    }

                    override fun onSuccess(t: Youtube) {
                        Log.i("test", t.toString())
                        setDataToRecycler(t.items)
                    }

                    override fun onError(e: Throwable) {
                        Log.i("test_error", e.toString())
                    }
                })
        }
    }

    private fun listeningInit() {
        with(youtubeViewModel) {
            getListeningPlayList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<Youtube> {

                    override fun onSubscribe(d: Disposable) {
                        compositeDisposable.add(d)
                    }

                    override fun onSuccess(t: Youtube) {
                        Log.i("test", t.toString())
                        setDataToRecycler(t.items)
                    }

                    override fun onError(e: Throwable) {
                        Log.i("test_error", e.toString())
                    }
                })
        }
    }

    private fun readingInit() {
        with(youtubeViewModel) {
            getReadingPlayList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<Youtube> {

                    override fun onSubscribe(d: Disposable) {
                        compositeDisposable.add(d)
                    }

                    override fun onSuccess(t: Youtube) {
                        Log.i("test", t.toString())
                        setDataToRecycler(t.items)
                    }

                    override fun onError(e: Throwable) {
                        Log.i("test_error", e.toString())
                    }
                })
        }
    }

    private fun speakingInit() {
        with(youtubeViewModel) {
            getSpeakingPlayList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<Youtube> {

                    override fun onSubscribe(d: Disposable) {
                        compositeDisposable.add(d)
                    }

                    override fun onSuccess(t: Youtube) {
                        Log.i("test", t.toString())
                        setDataToRecycler(t.items)
                    }

                    override fun onError(e: Throwable) {
                        Log.i("test_error", e.toString())
                    }
                })
        }
    }

    private fun writingInit() {
        with(youtubeViewModel) {
            getWritingPlayList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<Youtube> {

                    override fun onSubscribe(d: Disposable) {
                        compositeDisposable.add(d)
                    }

                    override fun onSuccess(t: Youtube) {
                        Log.i("test", t.toString())
                        setDataToRecycler(t.items)
                    }

                    override fun onError(e: Throwable) {
                        Log.i("test_error", e.toString())
                    }
                })
        }
    }

    private fun setDataToRecycler(data: List<Youtube.Item?>?) {
        Log.i("test2", data.toString())
        val myData = ArrayList(data!!)
        val filteredList = data.filter {
            !it!!.snippet!!.title!!.contains("Private video")
        }
        Log.i("test3", filteredList.toString())
        youtubeAdapter = YoutubeAdapter(filteredList as ArrayList<Youtube.Item?>, this)
        binding.recyclerViewContainer.adapter = youtubeAdapter
        binding.recyclerViewContainer.layoutManager =
            LinearLayoutManager(this.requireActivity(), RecyclerView.VERTICAL, true)
    }

    override fun onItemClickListener(itemClicked: Snippet) {
        val intent = YouTubeStandalonePlayer.createVideoIntent(
            this.requireActivity(), youTubeApiKey, itemClicked.resourceId?.videoId, 0, true, true
        )
        startActivity(intent)
    }
    private fun snackBar(){
        Snackbar.make(binding.root, R.string.NoInternet, Snackbar.LENGTH_SHORT)
            .setBackgroundTint(
                ContextCompat.getColor(
                    this.requireActivity(),
                    R.color.colorPrimary
                )
            )
            .show()
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}







