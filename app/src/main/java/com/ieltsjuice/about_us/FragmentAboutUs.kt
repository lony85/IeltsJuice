package com.ieltsjuice.about_us

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ieltsjuice.R
import com.ieltsjuice.adapters.AboutUsRecyclerAdapter
import com.ieltsjuice.databinding.FragmentAboutUsBinding
import com.ieltsjuice.model.Teacher
import com.ieltsjuice.model.Data

const val KEY_teacherName = "KEY_teacherName"
const val KEY_teacherTitle = "KEY_teacherTitle"
const val KEY_teacherDesc = "KEY_teacherDesc"
const val KEY_teacherInstagram = "KEY_teacherInstagram"
const val KEY_teacherLinkedin = "KEY_teacherLinkedin"
const val KEY_teacherFacebook = "KEY_teacherFacebook"
const val KEY_teacherSkype = "KEY_teacherSkype"
const val KEY_teacherWebpage = "KEY_teacherWebpage"
const val KEY_teacherImage = "KEY_teacherImage"

class FragmentAboutUs : Fragment(), AboutUsRecyclerAdapter.PressedBtn {
    lateinit var binding: FragmentAboutUsBinding
    private lateinit var teachersAdapter: AboutUsRecyclerAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutUsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        teachersAdapter = AboutUsRecyclerAdapter(this.requireActivity(), Data.Teachers, this)

        binding.aboutUsRecyclerView.adapter = teachersAdapter
        val layoutManager = LinearLayoutManager(this.requireActivity())
        binding.aboutUsRecyclerView.layoutManager = layoutManager
        binding.aboutUsRecyclerView.setHasFixedSize(true)

        //Social Media
        binding.skypeBtn.setOnClickListener {
            val skypeUri = Uri.parse("https://join.skype.com/invite/jDYbf4HtV0ZT")
            val iInsta = Intent(Intent.ACTION_VIEW, skypeUri)
            iInsta.setPackage("com.skype.raider")
            try {
                startActivity(iInsta)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://join.skype.com/invite/jDYbf4HtV0ZT")
                    )
                )
            }
        }
        binding.telegramBtn.setOnClickListener {
            val telegramUri = Uri.parse("https://telegram.me/ieltsjuice")
            val iInsta = Intent(Intent.ACTION_VIEW, telegramUri)
            iInsta.setPackage("org.telegram")
            try {
                startActivity(iInsta)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://telegram.me/ieltsjuice")
                    )
                )
            }
        }
        binding.youtubeBtn.setOnClickListener {
            val youtubeUri = Uri.parse("https://www.youtube.com/c/Ieltsjuice")
            val iInsta = Intent(Intent.ACTION_VIEW, youtubeUri)
            iInsta.setPackage("com.google.android.youtube")
            try {
                startActivity(iInsta)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.youtube.com/c/Ieltsjuice")
                    )
                )
            } }
        binding.instagramBtn.setOnClickListener {
            val instaUri = Uri.parse("https://www.instagram.com/ieltsjuice/")
            val iInsta = Intent(Intent.ACTION_VIEW, instaUri)
            iInsta.setPackage("com.instagram.android")

            try {
                startActivity(iInsta)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.instagram.com/ieltsjuice/")
                    )
                )
            }
        }
        binding.twitterBtn.setOnClickListener {
            val twitterUri = Uri.parse("https://twitter.com/ieltsjuice")
            val iInsta = Intent(Intent.ACTION_VIEW, twitterUri)
            iInsta.setPackage("com.twitter")
            try {
                startActivity(iInsta)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://twitter.com/ieltsjuice")
                    )
                )
        }}
        binding.facebookBtn.setOnClickListener {
            val facebookUri = Uri.parse("https://www.facebook.com/IeltsJuice/")
            val iInsta = Intent(Intent.ACTION_VIEW, facebookUri)
            iInsta.setPackage("com.facebook.android")

            try {
                startActivity(iInsta)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.facebook.com/IeltsJuice/")
                    )
                )
            }
        }
        binding.webSiteBtn.setOnClickListener {
            val webUri = Uri.parse("https://ieltsjuice.com/")
            val iWeb = Intent(Intent.ACTION_VIEW, webUri)
            iWeb.setPackage("com.android.chrome")
            try {
                startActivity(iWeb)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://ieltsjuice.com/")
                    )
                )
            }
        }


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
        replaceTransaction.replace(R.id.fragment_container, fragment)
        replaceTransaction.addToBackStack(null)
        replaceTransaction.commit()

    }
}