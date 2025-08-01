package com.ieltsjuice.about_us

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ieltsjuice.R
import com.ieltsjuice.databinding.FragmentAboutUsDetailsBinding
import com.ieltsjuice.util.*


class FragmentAboutUsDetails : Fragment() {
    lateinit var binding: FragmentAboutUsDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutUsDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            val teacherName = bundle.getString(KEY_teacherName)
            val teacherFamily = bundle.getString(KEY_teacherFamily)
            val teacherTitle = bundle.getString(KEY_teacherTitle)
            val teacherDescription = bundle.getString(KEY_teacherDesc)
            val teacherInstagram = bundle.getString(KEY_teacherInstagram)
            val teacherFacebook = bundle.getString(KEY_teacherFacebook)
            val teacherWebpage = bundle.getString(KEY_teacherWebpage)
            val teacherLinkedin = bundle.getString(KEY_teacherLinkedin)
            val teacherSkype = bundle.getString(KEY_teacherSkype)
            val teacherTelegram = bundle.getString(KEY_teacherTelegram)
            val teacherTwitter = bundle.getString(KEY_teacherTwitter)

            binding.webPage.setOnClickListener {
                val webUri = Uri.parse(teacherWebpage)
                val iWeb = Intent(Intent.ACTION_VIEW, webUri)
                iWeb.setPackage("com.android.chrome")
                try {
                    startActivity(iWeb)
                } catch (e: ActivityNotFoundException) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(teacherWebpage)
                        )
                    )
                }
            }
            binding.linkedin.setOnClickListener {
                val linkedinUri = Uri.parse(teacherLinkedin)
                val iLinkdin = Intent(Intent.ACTION_VIEW, linkedinUri)
                iLinkdin.setPackage("com.linkedin.android")

                try {
                    startActivity(iLinkdin)
                } catch (e: ActivityNotFoundException) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(teacherLinkedin)
                        )
                    )
                }
            }
            binding.facebook.setOnClickListener {
                val facebookUri = Uri.parse(teacherFacebook)
                val iFacebook = Intent(Intent.ACTION_VIEW, facebookUri)
                iFacebook.setPackage("com.facebook.android")

                try {
                    startActivity(iFacebook)
                } catch (e: ActivityNotFoundException) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(teacherFacebook)
                        )
                    )
                }
            }
            binding.instagram.setOnClickListener {
                val instaUri = Uri.parse(teacherInstagram)
                val iInsta = Intent(Intent.ACTION_VIEW, instaUri)
                iInsta.setPackage("com.instagram.android")

                    try {
                        startActivity(iInsta)
                    } catch (e: ActivityNotFoundException) {
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse(teacherInstagram)
                            )
                        )
                    }

            }
            binding.skype.setOnClickListener {
                val skypeUri = Uri.parse(teacherSkype)
                val iSkype = Intent(Intent.ACTION_VIEW, skypeUri)
                iSkype.setPackage("com.skype.raider")
                try {
                    startActivity(iSkype)
                } catch (e: ActivityNotFoundException) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(teacherSkype)
                        )
                    )
                }
            }
            binding.telegram.setOnClickListener {
                val telegramUri = Uri.parse(teacherTelegram)
                val iTelegram = Intent(Intent.ACTION_VIEW, telegramUri)
                iTelegram.setPackage("com.telegram")
                try {
                    startActivity(iTelegram)
                } catch (e: ActivityNotFoundException) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(teacherTelegram)
                        )
                    )
                }
            }
            binding.twitter.setOnClickListener {
                val twitterUri = Uri.parse(teacherTwitter)
                val iTwitter = Intent(Intent.ACTION_VIEW, twitterUri)
                iTwitter.setPackage("com.twitter.android")
                try {
                    startActivity(iTwitter)
                } catch (e: ActivityNotFoundException) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(teacherTwitter)
                        )
                    )
                }
            }

            binding.nameAboutDetails.text = teacherName
            binding.titleAboutDetails.text = teacherTitle
            binding.familyAboutDetails.text = teacherFamily
            binding.descriptionAboutDetails.text = teacherDescription
            bindImage(teacherName!!,teacherFamily!!)
        }
    }
    private fun bindImage(teacherName:String, teacherFamily: String) {
        when {

            teacherName =="Kasra" && teacherFamily == "Sharifan" -> {
                binding.imageViewAboutDetails.setImageResource(R.drawable.teacher_kasra_sharifan)
                binding.instagram.visibility = GONE
                binding.skype.visibility = GONE
                binding.telegram.visibility = GONE

            }
            teacherName =="Soolmaz" && teacherFamily == "Neishaboori" -> {
                binding.imageViewAboutDetails.setImageResource(R.drawable.teacher_soolmaz_neishaboori)
                binding.instagram.visibility = GONE
                binding.skype.visibility = GONE
                binding.webPage.visibility = GONE
                binding.telegram.visibility = GONE
                binding.twitter.visibility = GONE
            }
            teacherName =="Rahman" && teacherFamily == "Haghparast" -> {
                binding.imageViewAboutDetails.setImageResource(R.drawable.teacher_rahman)
                binding.instagram.visibility = GONE
                binding.skype.visibility = GONE
                binding.facebook.visibility = GONE
                binding.webPage.visibility = GONE
                binding.twitter.visibility = GONE
                binding.telegram.visibility = GONE
            }
            teacherName =="Hamed" && teacherFamily == "Hassanizawe" -> {
                binding.imageViewAboutDetails.setImageResource(R.drawable.teacher_hamed_hassanizawe)
                binding.skype.visibility = GONE
                binding.facebook.visibility = GONE
                binding.webPage.visibility = GONE
                binding.linkedin.visibility = GONE
                binding.instagram.visibility = GONE
                binding.textView.visibility = GONE
                binding.twitter.visibility = GONE
                binding.telegram.visibility = GONE
            }
            teacherName =="David" && teacherFamily == "Stanley Beggs" -> {
                binding.imageViewAboutDetails.setImageResource(R.drawable.teacher_david_beggs)
                binding.skype.visibility = GONE
                binding.webPage.visibility = GONE
                binding.instagram.visibility = GONE
                binding.facebook.visibility = GONE
                binding.telegram.visibility = GONE
                binding.twitter.visibility = GONE
                binding.linkedin.visibility = GONE
                binding.textView.visibility = GONE

            }
            teacherName =="Elham" && teacherFamily == "Hedeshi" -> {
                binding.imageViewAboutDetails.setImageResource(R.drawable.teacher_elham_hedeshi)
                binding.skype.visibility = GONE
                binding.webPage.visibility = GONE
                binding.linkedin.visibility = GONE
                binding.telegram.visibility = GONE
                binding.twitter.visibility = GONE
            }
            teacherName =="Saghy" && teacherFamily == "Ghassemi" -> {
                binding.imageViewAboutDetails.setImageResource(R.drawable.teacher_saghy_ghassemi)
                binding.skype.visibility = GONE
                binding.facebook.visibility = GONE
                binding.webPage.visibility = GONE
                binding.instagram.visibility = GONE
                binding.twitter.visibility = GONE
                binding.telegram.visibility = GONE
            }
            teacherName =="Marzieh" && teacherFamily == "Naseri" -> {
                binding.imageViewAboutDetails.setImageResource(R.drawable.teacher_marzieh_naseri)
                binding.skype.visibility = GONE
                binding.webPage.visibility = GONE
                binding.instagram.visibility = GONE
                binding.facebook.visibility = GONE
                binding.linkedin.visibility = GONE
                binding.twitter.visibility = GONE
                binding.telegram.visibility = GONE
                binding.textView.visibility = GONE

            }
            teacherName =="Mehryar" && teacherFamily == "Kishi" -> {
                binding.imageViewAboutDetails.setImageResource(R.drawable.teacher_mehryar_kishi)
                binding.skype.visibility = GONE
                binding.facebook.visibility = GONE
                binding.webPage.visibility = GONE
                binding.twitter.visibility = GONE
                binding.telegram.visibility = GONE
            }
            teacherName =="Mehdi" && teacherFamily == "Safavi" -> {

                binding.imageViewAboutDetails.setImageResource(R.drawable.teacher_mehdi_safavi)
                binding.twitter.visibility = GONE
                binding.telegram.visibility = GONE
            }
            teacherName =="Sadegh" && teacherFamily == "Keshtkar" -> {
                binding.imageViewAboutDetails.setImageResource(R.drawable.teacher_sadegh_keshtkar)
                binding.skype.visibility = GONE
                binding.facebook.visibility = GONE
                binding.webPage.visibility = GONE
                binding.telegram.visibility = GONE
                binding.twitter.visibility = GONE
            }
            teacherName =="Elham" && teacherFamily == "Naseri" -> {
                binding.imageViewAboutDetails.setImageResource(R.drawable.teacher_elham_naseri)
                binding.skype.visibility = GONE
                binding.facebook.visibility = GONE
                binding.webPage.visibility = GONE
                binding.instagram.visibility = GONE
                binding.telegram.visibility = GONE
                binding.twitter.visibility = GONE

            }
            teacherName =="Shahab" && teacherFamily == "Hosseinzadeh" -> {
                binding.imageViewAboutDetails.setImageResource(R.drawable.teacher_leila_hosseinzadeh)
                binding.facebook.visibility = GONE
                binding.webPage.visibility = GONE
                binding.linkedin.visibility = GONE
                binding.skype.visibility = GONE
                binding.twitter.visibility = GONE
                binding.telegram.visibility = GONE
                binding.instagram.visibility = GONE
                binding.textView.visibility = GONE
            }
        }
    }
}