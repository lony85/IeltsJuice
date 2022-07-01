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
import com.ieltsjuice.WithoutBottomNavigationBarActivity
import com.ieltsjuice.adapters.AboutUsRecyclerAdapter
import com.ieltsjuice.databinding.FragmentAboutUsBinding
import com.ieltsjuice.model.Teacher
import com.ieltsjuice.model.Data



class FragmentAboutUs : Fragment(), AboutUsRecyclerAdapter.PressedBtn {
    lateinit var binding: FragmentAboutUsBinding
    lateinit var fragmentAboutUsViewModel: FragmentAboutUsViewModel
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

        fragmentAboutUsViewModel = FragmentAboutUsViewModel()

        // our team Recycler View
        teachersAdapter = AboutUsRecyclerAdapter(this.requireActivity(), Data.Teachers, this)
        binding.aboutUsRecyclerView.adapter = teachersAdapter
        val layoutManager = LinearLayoutManager(this.requireActivity(),LinearLayoutManager.HORIZONTAL,false)
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
        val intent = Intent(this.requireActivity(),WithoutBottomNavigationBarActivity::class.java)
        fragmentAboutUsViewModel.putExtra(intent,teacher)
        startActivity(intent)
    }
}