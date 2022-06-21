package com.ieltsjuice.youtube

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ieltsjuice.databinding.TemplateYoutubeContentBinding
import com.ieltsjuice.model.Youtube

class YoutubeAdapter(val youtube: ArrayList<Youtube.Item?>, private val pressed: PressedBtn) :
    RecyclerView.Adapter<YoutubeAdapter.Holder>() {

    inner class Holder(private val binding: TemplateYoutubeContentBinding) : RecyclerView.ViewHolder(binding.root) {

       fun bindData(category: Youtube.Item.Snippet) {

            binding.txtTitleYoutube.text = category.title
            binding.txtDescYoutube.text = category.description
            binding.txtDataYoutube.text = category.publishTime

           Glide.with(binding.root)
               .load(category.thumbnails!!.default!!.url)
               .into(binding.imgThumbnailYoutube)

            itemView.setOnClickListener {
                pressed.onItemClickListener(category)
            }
            
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = TemplateYoutubeContentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindData(youtube[position]?.snippet!!)
    }

    override fun getItemCount(): Int {
        return youtube.size
    }

    // 1.create interface in adapter
    // 2. get an object of interface in args of adapter
    // 3. fill (or call) object of interface with your date
    // 4. implementation in MainActivity
    interface PressedBtn{
        fun onItemClickListener(itemClicked:Youtube.Item.Snippet)
    }
}