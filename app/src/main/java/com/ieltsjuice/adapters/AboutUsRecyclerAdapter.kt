package com.ieltsjuice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ieltsjuice.R
import com.ieltsjuice.model.Teacher

class AboutUsRecyclerAdapter(val context: Context, val Teachers: List<Teacher>,private val pressed: PressedBtn) :
    RecyclerView.Adapter<AboutUsRecyclerAdapter.Holder>() {
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val teacherImage: ImageView = itemView.findViewById(R.id.imageView_about_RecyclerView)
        private val teacherName: TextView = itemView.findViewById(R.id.name_about_Details)
        private val teacherFamily:TextView = itemView.findViewById(R.id.family_about_Details)
        private val teacherTitle: TextView = itemView.findViewById(R.id.title_about_Details)

        private val moreButton: Button = itemView.findViewById(R.id.btn_more_aboutUs)

        fun bindData(category: Teacher, context: Context) {
            val resourceId =
                context.resources.getIdentifier(category.image, "drawable", context.packageName)

            teacherImage.setImageResource(resourceId)
            teacherName.text = category.teacherName
            teacherTitle.text = category.title
            teacherFamily.text = category.teacherFamily

            moreButton.setOnClickListener {
                pressed.moreInfoBtn(Teachers[adapterPosition],adapterPosition)
            }
            
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.template_about_us, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindData(Teachers[position], context)
    }

    override fun getItemCount(): Int {
        return Teachers.count()
    }

    // 1.create interface in adapter
    // 2. get an object of interface in args of adapter
    // 3. fill (or call) object of interface with your date
    // 4. implementation in MainActivity
    interface PressedBtn{
        fun moreInfoBtn(teacher: Teacher,position: Int)
    }
}