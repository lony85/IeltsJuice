package com.ieltsjuice.about_us

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ieltsjuice.R
import com.ieltsjuice.adapters.AboutUsRecyclerAdapter
import com.ieltsjuice.databinding.FragmentOurTeamBinding
import com.ieltsjuice.model.Data
import com.ieltsjuice.model.Teacher

class FragmentOurTeam:Fragment() , AboutUsRecyclerAdapter.PressedBtn{
lateinit var binding:FragmentOurTeamBinding
    private lateinit var teachersAdapter: AboutUsRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOurTeamBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        teachersAdapter = AboutUsRecyclerAdapter(this.requireActivity(), Data.Teachers, this)

        binding.aboutUsRecyclerView.adapter = teachersAdapter
        val layoutManager = LinearLayoutManager(this.requireActivity())
        binding.aboutUsRecyclerView.layoutManager = layoutManager
        binding.aboutUsRecyclerView.setHasFixedSize(true)

    }
    override fun moreInfoBtn(teacher: Teacher, position: Int) {
        val bundle = Bundle()
        bundle.putString(KEY_teacherName, teacher.teacherName)
        bundle.putString(KEY_teacherTitle, teacher.title)
        bundle.putString(KEY_teacherDesc, teacher.description)
        bundle.putString(KEY_teacherImage, teacher.title)
        bundle.putString(KEY_teacherFacebook, teacher.facebook)
        bundle.putString(KEY_teacherLinkedin, teacher.linkedin)
        bundle.putString(KEY_teacherInstagram, teacher.instagram)
        bundle.putString(KEY_teacherWebpage, teacher.webpage)
        bundle.putString(KEY_teacherSkype, teacher.skype)
        val fragment = FragmentAboutUsDetails()
        fragment.arguments = bundle

        val replaceTransaction = parentFragmentManager.beginTransaction()
        replaceTransaction.replace(R.id.nav_host_fragment_activity_main, fragment)
        replaceTransaction.addToBackStack(null)
        replaceTransaction.commit()

    }

}