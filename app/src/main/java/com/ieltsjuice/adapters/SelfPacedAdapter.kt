package com.ieltsjuice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ieltsjuice.R
import com.ieltsjuice.model.SelfPacedCourses


class SelfPacedAdapter(
    val context: Context, private val Courses: List<SelfPacedCourses>,
    val selectedView: ViewSelected
) :
    RecyclerView.Adapter<SelfPacedAdapter.Holder>() {
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val courseTitle: TextView = itemView.findViewById(R.id.txtTitle_course_Details)
        private val courseIcon: ImageView = itemView.findViewById(R.id.iconStatus_course_RecyclerView)

        fun bindData(category: SelfPacedCourses, context: Context) {

            val resourceIdIcon =
                context.resources.getIdentifier(category.icon, "drawable", context.packageName)

            courseTitle.text = category.Title
            courseIcon.setImageResource(resourceIdIcon)

            itemView.setOnClickListener {
                selectedView.selectedView(Courses[adapterPosition],adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.template_course_content, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindData(Courses[position], context)
    }

    override fun getItemCount(): Int {
        return Courses.count()
    }

    // 1.create interface in adapter
    // 2. get an object of interface in args of adapter
    // 3. fill (or call) object of interface with your date
    // 4. implementation in MainActivity
    interface ViewSelected{
        fun selectedView(Course:SelfPacedCourses,position: Int)
    }
}