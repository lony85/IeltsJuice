package com.ieltsjuice.youtube

import android.graphics.YuvImage
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ieltsjuice.databinding.FragmentYoutubeBinding
import com.ieltsjuice.model.Youtube
import com.ieltsjuice.model.Youtube.Item.Snippet
import com.ieltsjuice.model.YoutubeRepository
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class FragmentYoutube : Fragment() ,YoutubeAdapter.PressedBtn{
    lateinit var binding : FragmentYoutubeBinding
    lateinit var youtubeViewModel: YoutubeViewModel
    private val compositeDisposable = CompositeDisposable()
    lateinit var youtubeAdapter: YoutubeAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentYoutubeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        youtubeViewModel = YoutubeViewModel(YoutubeRepository())

        with(youtubeViewModel) {
            getListeningPlayList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<Youtube>{

                    override fun onSubscribe(d: Disposable) {
                        compositeDisposable.add(d)
                    }

                    override fun onSuccess(t: Youtube) {
                        Log.i("test",t.items.toString())
                        setDataToRecycler( t.items )
                    }

                    override fun onError(e: Throwable) {
                        Log.i("test_error",e.toString())
                    }

                })
        }

    }

    private fun setDataToRecycler(data: List<Youtube.Item?>?) {
        val myData = ArrayList(data)
        youtubeAdapter = YoutubeAdapter(myData, this)
        binding.recyclerViewContainer.adapter = youtubeAdapter
        binding.recyclerViewContainer.layoutManager = LinearLayoutManager(this.requireActivity(), RecyclerView.VERTICAL, false)
    }

    override fun onItemClickListener(itemClicked: Snippet) {
        //TODO intent
    }
    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}







