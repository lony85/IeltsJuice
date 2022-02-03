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


class FragmentAboutUsDetails : Fragment() {
    lateinit var binding: FragmentAboutUsDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutUsDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            val teacherName = bundle.getString(KEY_teacherName)
            val teacherTitle = bundle.getString(KEY_teacherTitle)
            val teacherDescription = bundle.getString(KEY_teacherDesc)
            val teacherInstagram = bundle.getString(KEY_teacherInstagram)
            val teacherFacebook = bundle.getString(KEY_teacherFacebook)
            val teacherWebpage = bundle.getString(KEY_teacherWebpage)
            val teacherLinkedin = bundle.getString(KEY_teacherLinkedin)
            val teacherSkype = bundle.getString(KEY_teacherSkype)

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
                val iInsta = Intent(Intent.ACTION_VIEW, linkedinUri)
                iInsta.setPackage("com.linkedin.android")

                try {
                    startActivity(iInsta)
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
                val iInsta = Intent(Intent.ACTION_VIEW, facebookUri)
                iInsta.setPackage("com.facebook.android")

                try {
                    startActivity(iInsta)
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
                val iInsta = Intent(Intent.ACTION_VIEW, skypeUri)
                iInsta.setPackage("com.skype.raider")
                try {
                    startActivity(iInsta)
                } catch (e: ActivityNotFoundException) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(teacherSkype)
                        )
                    )
                }
            }

            binding.nameAboutDetails.text = teacherName
            binding.titleAboutDetails.text = teacherTitle
            binding.descriptionAboutDetails.text = teacherDescription
            bindImage(teacherName!!)
        } else {
            //Todo
        }

    }

    private fun bindImage(teacherName: String) {
        when (teacherName) {

            "Kasra Sharifan" -> {
                binding.imageViewAboutDetails.setImageResource(R.drawable.teacher_kasra_sharifan)
                binding.instagram.visibility = GONE
                binding.skype.visibility = GONE

            }
            "Soolmaz Neishaboori" -> {
                binding.imageViewAboutDetails.setImageResource(R.drawable.teacher_soolmaz_neishaboori)
                binding.instagram.visibility = GONE
                binding.skype.visibility = GONE
                binding.webPage.visibility = GONE
            }
            "Rahman Haghparast" -> {
                binding.imageViewAboutDetails.setImageResource(R.drawable.teacher_rahman)
                binding.instagram.visibility = GONE
                binding.skype.visibility = GONE
                binding.facebook.visibility = GONE
                binding.webPage.visibility = GONE
            }
            "Hamed Hassanizawe" -> {
                binding.imageViewAboutDetails.setImageResource(R.drawable.teacher_hamed_hassanizawe)
                binding.skype.visibility = GONE
                binding.facebook.visibility = GONE
                binding.webPage.visibility = GONE
                binding.linkedin.visibility = GONE

            }
            "David Stanley Beggs" -> {
                binding.imageViewAboutDetails.setImageResource(R.drawable.teacher_david_beggs)
                binding.skype.visibility = GONE
                binding.webPage.visibility = GONE
                binding.instagram.visibility = GONE
            }
            "Elham Hedeshi" -> {
                binding.imageViewAboutDetails.setImageResource(R.drawable.teacher_elham_hedeshi)
                binding.skype.visibility = GONE
                binding.webPage.visibility = GONE
                binding.linkedin.visibility = GONE
            }
            "Saghy Ghassemi" -> {
                binding.imageViewAboutDetails.setImageResource(R.drawable.teacher_saghy_ghassemi)
                binding.skype.visibility = GONE
                binding.facebook.visibility = GONE
                binding.webPage.visibility = GONE
                binding.instagram.visibility = GONE
            }
            "Mehryar Kishi" -> {
                binding.imageViewAboutDetails.setImageResource(R.drawable.teacher_mehryar_kishi)
                binding.skype.visibility = GONE
                binding.facebook.visibility = GONE
                binding.webPage.visibility = GONE
            }
            "Mehdi Safavi" -> {
                binding.imageViewAboutDetails.setImageResource(R.drawable.teacher_mehdi_safavi)
            }
            "Sadegh Keshtkar" -> {
                binding.imageViewAboutDetails.setImageResource(R.drawable.teacher_sadegh_keshtkar)
                binding.skype.visibility = GONE
                binding.facebook.visibility = GONE
                binding.webPage.visibility = GONE
            }
            "Elham Naseri" -> {
                binding.imageViewAboutDetails.setImageResource(R.drawable.teacher_elham_naseri)
                binding.skype.visibility = GONE
                binding.facebook.visibility = GONE
                binding.webPage.visibility = GONE
                binding.linkedin.visibility = GONE
                binding.instagram.visibility = GONE
                binding.textView.visibility = GONE
            }
            "ShB Hosseinzadeh" -> {
                binding.imageViewAboutDetails.setImageResource(R.drawable.teacher_leila_hosseinzadeh)
                binding.facebook.visibility = GONE
                binding.webPage.visibility = GONE
                binding.linkedin.visibility = GONE
                binding.skype.visibility = GONE

            }
        }

    }

}