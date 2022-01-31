package com.ieltsjuice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ieltsjuice.adapters.AboutUsRecyclerAdapter
import com.ieltsjuice.databinding.FragmentAboutUsBinding
import com.ieltsjuice.model.Teacher
import com.ieltsjuice.model.data
import kotlin.concurrent.fixedRateTimer

const val KEY_teacherName = "KEY_teacherName"
const val KEY_teacherTitle = "KEY_teacherTitle"
const val KEY_teacherDesc = "KEY_teacherDesc"
const val KEY_teacherInstagram = "KEY_teacherInstagram"
const val KEY_teacherLinkedin = "KEY_teacherLinkedin"
const val KEY_teacherFacebook = "KEY_teacherFacebook"
const val KEY_teacherSkype = "KEY_teacherSkype"
const val KEY_teacherWebpage = "KEY_teacherWebpage"

class FragmentAboutUs : Fragment(), AboutUsRecyclerAdapter.PressedBtn{
    lateinit var binding : FragmentAboutUsBinding
    lateinit var TeachersAdapter :AboutUsRecyclerAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutUsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        TeachersAdapter = AboutUsRecyclerAdapter(this.requireActivity(),data.Teachers,this)

        binding.aboutUsRecyclerView.adapter = TeachersAdapter
        val layoutManager = LinearLayoutManager(this.requireActivity())
        binding.aboutUsRecyclerView.layoutManager = layoutManager
        binding.aboutUsRecyclerView.setHasFixedSize(true)
    }

    override fun moreInfoBtn(teacher: Teacher, position: Int) {
        val bundle = Bundle()
//        bundle.putString("TeacherName","salam")
        bundle.putString(KEY_teacherName,teacher.teacherName)
        bundle.putString(KEY_teacherTitle,teacher.title)
        bundle.putString(KEY_teacherDesc,teacher.description)
        bundle.putString("KEY_teacherImage",teacher.title)
        bundle.putString(KEY_teacherFacebook,teacher.facebook)
        bundle.putString(KEY_teacherLinkedin,teacher.linkedin)
        bundle.putString(KEY_teacherInstagram,teacher.instagram)
        bundle.putString(KEY_teacherWebpage,teacher.webpage)
        bundle.putString(KEY_teacherSkype,teacher.skype)
        val fragment = FragmentAboutUsDetails()
        fragment.arguments = bundle

        val replaceTransaction = parentFragmentManager.beginTransaction()
        replaceTransaction.replace(R.id.fragment_container,fragment)
        replaceTransaction.addToBackStack(null)
        replaceTransaction.commit()

    }
}