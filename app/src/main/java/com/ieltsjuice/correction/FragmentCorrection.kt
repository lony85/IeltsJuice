package com.ieltsjuice.correction

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ieltsjuice.databinding.FragmentCorrectionBinding

class FragmentCorrection : Fragment() {
    lateinit var binding: FragmentCorrectionBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCorrectionBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonCorrectionIranDiscount.setOnClickListener {
            val webUri = Uri.parse("https://forush.co/4751/881160/")
            val iWeb = Intent(Intent.ACTION_VIEW, webUri)
            iWeb.setPackage("com.android.chrome")
            try {
                startActivity(iWeb)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://forush.co/4751/881160/")
                    )
                )
            }
        }
        binding.buttonCorrectionIranExpress.setOnClickListener {
            val webUri = Uri.parse("https://forush.co/6086/683111/")
            val iWeb = Intent(Intent.ACTION_VIEW, webUri)
            iWeb.setPackage("com.android.chrome")
            try {
                startActivity(iWeb)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://forush.co/6086/683111/")
                    )
                )
            }
        }
        binding.buttonCorrectionSendNow.setOnClickListener {
            val webUri = Uri.parse("https://ieltsjuice.com/services/writing-correction/")
            val iWeb = Intent(Intent.ACTION_VIEW, webUri)
            iWeb.setPackage("com.android.chrome")
            try {
                startActivity(iWeb)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://ieltsjuice.com/services/writing-correction/")
                    )
                )
            }
        }
        binding.buttonCorrectionContactUs.setOnClickListener {
            val webUri = Uri.parse("https://ieltsjuice.com/contact/")
            val iWeb = Intent(Intent.ACTION_VIEW, webUri)
            iWeb.setPackage("com.android.chrome")
            try {
                startActivity(iWeb)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://ieltsjuice.com/contact/")
                    )
                )
            }
        }
    }
}